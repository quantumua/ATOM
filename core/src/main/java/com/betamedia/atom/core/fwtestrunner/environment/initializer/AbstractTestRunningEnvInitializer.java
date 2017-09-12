package com.betamedia.atom.core.fwtestrunner.environment.initializer;

import com.betamedia.atom.core.dsl.templates.BackEndOperationsTemplate;
import com.betamedia.atom.core.dsl.templates.tp.TPTemplateProvider;
import com.betamedia.atom.core.dsl.type.EnvironmentType;
import com.betamedia.atom.core.fwdataaccess.converters.ZonedDateTimeConverter;
import com.betamedia.atom.core.fwdataaccess.repository.impl.LocalizationRepository;
import com.betamedia.atom.core.fwdataaccess.repository.impl.VersionedLocalizationRepositoryImpl;
import com.betamedia.atom.core.fwdataaccess.repository.impl.VersionedWebElementRepositoryImpl;
import com.betamedia.atom.core.fwdataaccess.repository.impl.WebElementRepository;
import com.betamedia.atom.core.fwdataaccess.repository.util.RepositoryVersion;
import com.betamedia.atom.core.fwdataaccess.repository.util.version.ApplicationVersionService;
import com.betamedia.atom.core.fwdataaccess.repository.util.version.ApplicationVersionServiceProvider;
import com.betamedia.atom.core.fwservices.webdriver.WebDriverFactory;
import com.betamedia.atom.core.fwservices.webdriver.WebDriverFactoryProvider;
import com.betamedia.atom.core.holders.ThreadLocalBeansHolder;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Properties;

import static com.betamedia.atom.core.dsl.type.TestConfigurationKeys.*;

/**
 * @author Maksym Tsybulskyy
 *         Date: 9/12/17.
 */
//TODO finish generification for different product type
public abstract class AbstractTestRunningEnvInitializer<T extends BackEndOperationsTemplate> implements TestRunningEnvInitializer{

    @Autowired
    private ApplicationVersionServiceProvider applicationVersionServiceProvider;
    @Autowired
    private WebDriverFactoryProvider webDriverFactoryProvider;
    @Autowired
    private WebElementRepository webElementRepository;
    @Autowired
    private LocalizationRepository localizationRepository;

    @Override
    public void initializeEnvironment(Properties properties) {
        if (Objects.isNull(ThreadLocalBeansHolder.getWebDriverFactory())) {
            ThreadLocalBeansHolder.setWebDriverFactory(getWebDriverFactory(properties));
        }
        if (Objects.isNull(ThreadLocalBeansHolder.getVersionedWebElementRepository())) {
            ThreadLocalBeansHolder.setVersionedWebElementRepository(new VersionedWebElementRepositoryImpl(getAppVersion(properties), webElementRepository));
        }
        if (Objects.isNull(ThreadLocalBeansHolder.getVersionedLocalizationRepository())) {
            ThreadLocalBeansHolder.setVersionedLocalizationRepository(new VersionedLocalizationRepositoryImpl(getAppVersion(properties), localizationRepository));
        }
        if (Objects.isNull(ThreadLocalBeansHolder.getOperationsTemplate())) {
            ThreadLocalBeansHolder.setOperationsTemplate(getOperationsTemplate(properties));
        }
    }

    private WebDriverFactory getWebDriverFactory(Properties properties) {
        String domainUrl = properties.getProperty(ENVIRONMENT_URL.getKey());
        String remoteDriverUrl = properties.getProperty(REMOTE_DRIVER_URL.getKey());
        String browserType = properties.getProperty(BROWSER_TYPE.getKey());
        return webDriverFactoryProvider.get(browserType, remoteDriverUrl, domainUrl);
    }

    private T getOperationsTemplate(Properties properties){
        return (T) getTemplateProvider().get(getEnvironment(properties));
    }

    //TODO generify TemplateProvider
    protected abstract TPTemplateProvider getTemplateProvider();


    private ApplicationVersionService getApplicationVersionService(Properties properties) {
        return applicationVersionServiceProvider.get(getEnvironment(properties));
    }

    private EnvironmentType getEnvironment(Properties properties) {
        return EnvironmentType.parse(properties.getProperty(ENVIRONMENT.getKey(), EnvironmentType.QA.getValue()));
    }

    /**
     * {@link RepositoryVersion} lookup strategy:
     * <li>
     * <ul>- If there is no implementation version provided in test.properties file, try to obtain it from {@link ApplicationVersionService}</ul>
     * <ul>- Otherwise, use provided implementation version and, if present, revision date</ul>
     * </li>
     */
    private RepositoryVersion getAppVersion(Properties properties) {
        String implementationVersion = properties.getProperty(IMPLEMENTATION_VERSION.getKey());
        if (Strings.isNullOrEmpty(implementationVersion)) {
            return getApplicationVersionService(properties).getVersion();
        }
        String dateString = properties.getProperty(REVISION_DATE.getKey());
        return new RepositoryVersion(implementationVersion, Strings.isNullOrEmpty(dateString) ? null : getRevisionDate(dateString));
    }

    private static ZonedDateTime getRevisionDate(String dateString) {
        return ZonedDateTime.parse(dateString, DateTimeFormatter.ofPattern(ZonedDateTimeConverter.DATE_PATTERN));
    }
}
