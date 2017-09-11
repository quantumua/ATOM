package com.betamedia.atom.core.fwdataaccess.converters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mbelyaev
 * @since 5/31/17
 */
public class ZonedDateTimeConverter extends AbstractBeanField<ZonedDateTime> {
    public static final String DATE_PATTERN = "y-M-d H:m Z";

    @Override
    public Object convert(String value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, CsvConstraintViolationException {
        return ZonedDateTime.parse(value, DateTimeFormatter.ofPattern(DATE_PATTERN));
    }
}
