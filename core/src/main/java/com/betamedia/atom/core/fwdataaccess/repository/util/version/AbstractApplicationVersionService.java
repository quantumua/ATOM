package com.betamedia.atom.core.fwdataaccess.repository.util.version;

import com.betamedia.atom.core.configuration.properties.CRMProperties;
import com.betamedia.atom.core.environment.tp.EnvironmentDependent;
import com.betamedia.atom.core.fwdataaccess.converters.ZonedDateTimeConverter;
import com.betamedia.atom.core.fwdataaccess.repository.util.RepositoryVersion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author mbelyaev
 * @since 3/10/17
 */
public abstract class AbstractApplicationVersionService<T extends EnvironmentDependent> implements ApplicationVersionService {
    private static final Logger logger = LogManager.getLogger(AbstractApplicationVersionService.class);
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(ZonedDateTimeConverter.DATE_PATTERN);
    @Autowired
    private CRMProperties<T> crmProperties;
    @Autowired
    private RestTemplateBuilder builder;
    @Autowired
    private ObjectMapper mapper;

    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        restTemplate = builder.build();
    }

    @Override
    public RepositoryVersion getVersion() {
        return getVersion(crmProperties.getBackOfficeVersionUrl());
    }


    private RepositoryVersion getVersion(String address) {
        ApplicationVersion appVersion = getAppVersion(address);
        return new RepositoryVersion(appVersion.implementationVersion, parseDateTime(appVersion.revisionDate));
    }

    /**
     * TODO: extract backoffice HTTP connections to AbstractHTTPConnector
     * Content-type is broken at backoffice, returns application/octet-stream instead of JSON
     * So we retrieve it as plain string and map to object manually
     */
    private ApplicationVersion getAppVersion(String address) {
        try {
            return mapper.readValue(restTemplate.getForObject(address, String.class), ApplicationVersion.class);
        } catch (IOException | RestClientException e) {
            logger.error("Could not retrieve application version from server:", e);
            return new ApplicationVersion();
        }
    }

    private ZonedDateTime parseDateTime(String dateTime) {
        return Optional.of(dateTime).map(date -> ZonedDateTime.parse(date, dateFormatter)).orElse(null);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ApplicationVersion {

        private String revisionDate = null;
        private String implementationVersion = null;

        public void setRevisionDate(String revisionDate) {
            this.revisionDate = Optional.of(revisionDate).map(ApplicationVersion::trimQuotes).orElse(null);
        }

        public void setImplementationVersion(String implementationVersion) {
            this.implementationVersion = Optional.of(implementationVersion).map(ApplicationVersion::trimVersionPostfix).orElse(null);
        }

        public String getRevisionDate() {
            return revisionDate;
        }

        public String getImplementationVersion() {
            return implementationVersion;
        }

        private static String trimQuotes(String input) {
            return input.replaceAll("^\"|\"$", "");
        }

        private static String trimVersionPostfix(String input) {
            return input.split("-", 2)[0];
        }
    }
}
