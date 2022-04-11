package se.parkster.rps;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GreetingTest {

    @Test
    void trims_greeting() {
        // When
        Greeting greeting = new Greeting(UUID.randomUUID(), " greet  ");

        // Then
        assertThat(greeting.text()).isEqualTo("greet");
    }
}