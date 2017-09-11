package com.betamedia.atom.core.fwdataaccess.repository.util.version;

import com.betamedia.atom.core.configuration.properties.CRMProperties;
import com.betamedia.atom.core.environment.tp.EnvironmentDependent;
import com.betamedia.atom.core.fwdataaccess.repository.util.RepositoryVersion;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.ZonedDateTime;

/**
 * @author mbelyaev
 * @since 3/10/17
 */
public abstract class AbstractApplicationVersionService<T extends EnvironmentDependent> implements ApplicationVersionService {
    private static final Logger logger = LogManager.getLogger(AbstractApplicationVersionService.class);
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
        return new RepositoryVersion(appVersion.implementationVersion, appVersion.revisionDate);
    }

    private ApplicationVersion getAppVersion(String address) {
        try {
            return mapper.readValue(restTemplate.getForObject(address, String.class), ApplicationVersion.class);
        } catch (IOException | RestClientException e) {
            logger.error("Could not retrieve application version from server:", e);
            return new ApplicationVersion();
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class ApplicationVersion {
        @JsonDeserialize(using = DateDeserializer.class)
        private ZonedDateTime revisionDate = null;
        @JsonDeserialize(using = VersionDeserializer.class)
        private String implementationVersion = null;
    }

}
