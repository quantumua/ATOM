package com.betamedia.atom.core.fwdataaccess.entities;

import com.betamedia.atom.core.fwdataaccess.converters.ZonedDateTimeConverter;
import com.betamedia.atom.core.fwdataaccess.repository.util.Index;
import com.betamedia.atom.core.fwdataaccess.repository.util.RepositoryVersion;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;

import java.time.ZonedDateTime;

/**
 * @author mbelyaev
 * @since 2/16/17
 */
public class LocalizationEntry {

    @CsvBindByName
    private String pageObjectName;
    @CsvBindByName
    private String locatorId;
    @CsvBindByName
    private String implementationVersion;
    @CsvCustomBindByName(converter = ZonedDateTimeConverter.class)
    private ZonedDateTime revisionDate;
    @CsvBindByName
    private String text;

    public String getPageObjectName() {
        return pageObjectName;
    }

    public String getLocatorId() {
        return locatorId;
    }

    public RepositoryVersion getRepositoryVersion() {
        return new RepositoryVersion(implementationVersion, revisionDate);
    }


    public String getText() {
        return text;
    }

    public Index getIndex() {
        return new Index(pageObjectName, locatorId);
    }
}
