package com.betamedia.atom.core.fwdataaccess.repository.util.version;

import com.betamedia.atom.core.fwdataaccess.converters.ZonedDateTimeConverter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author mbelyaev
 * @since 9/11/17
 */
class DateDeserializer extends StdDeserializer<ZonedDateTime> {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(ZonedDateTimeConverter.DATE_PATTERN);

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        return Optional.of(jsonParser.getText())
                .map(DateDeserializer::trimQuotes)
                .map(date -> ZonedDateTime.parse(date, dateFormatter))
                .orElse(null);
    }

    private static String trimQuotes(String input) {
        return input.replaceAll("^\"|\"$", "");
    }

    public DateDeserializer() {
        this(null);
    }

    protected DateDeserializer(Class<?> vc) {
        super(vc);
    }
}
