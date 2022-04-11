package se.parkster.rps;

import org.springframework.util.StringUtils;

import java.util.UUID;

public record Greeting(UUID id, String text) {

    public Greeting {
        text = StringUtils.trimWhitespace(text);
    }
}
