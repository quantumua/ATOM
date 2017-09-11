package com.betamedia.atom.core.fwdataaccess.repository.util.version;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Optional;

/**
 * @author mbelyaev
 * @since 9/11/17
 */
class VersionDeserializer extends StdDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
        return Optional.of(jsonParser.getText())
                .map(VersionDeserializer::trimVersionPostfix)
                .orElse(null);
    }

    private static String trimVersionPostfix(String input) {
        return input.split("-", 2)[0];
    }

    public VersionDeserializer() {
        this(null);
    }

    protected VersionDeserializer(Class<?> vc) {
        super(vc);
    }
}
