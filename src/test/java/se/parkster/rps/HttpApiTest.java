package se.parkster.rps;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class HttpApiTest {

    @LocalServerPort
    private int port;

    @Autowired
    private Database database;


    @AfterEach
    void clearDatabaseAfterEachTest() {
        database.clear();
    }

    @Test
    void post_to_greetings_saves_the_greeting_to_the_database_and_redirects_to_index() {
        given().
                port(port).
                formParam("greeting", "my greeting").
        when().
                post("/greetings").
        then().
                header("location", "http://localhost:%s/".formatted(port)).
                statusCode(302);


        assertThat(database.findAll())
                .extracting(Greeting::text)
                .containsOnly("my greeting");
    }
}
