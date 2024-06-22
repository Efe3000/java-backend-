package be.ucll.integration;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

import be.ucll.repository.DbInitializer;
import be.ucll.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@Sql("classpath:schema.sql")
public class UserIntegrationTest {

    @Autowired
    private WebTestClient client;
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private DbInitializer dbInitializer;    

        @BeforeEach
        public void setup() {
        dbInitializer.initialize();
        }



    @Test
    public void givenUsers_whenInvokingGetUser_thenUsersAreReturned() {
    client.get()
    .uri("/users")
    .exchange()
    .expectStatus().is2xxSuccessful()
    .expectBody()
    .json("[\n" + //
                "  {\n" + //
                "    \"name\": \"John Doe\",\n" + //
                "    \"password\": \"john1234\",\n" + //
                "    \"email\": \"john.doe@ucll.be\",\n" + //
                "    \"age\": 25\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Jane Toe\",\n" + //
                "    \"password\": \"jane1234\",\n" + //
                "    \"email\": \"jane.toe@ucll.be\",\n" + //
                "    \"age\": 30\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Jack Doe\",\n" + //
                "    \"password\": \"jack1234\",\n" + //
                "    \"email\": \"jack.doe@ucll.be\",\n" + //
                "    \"age\": 5\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Sarah Doe\",\n" + //
                "    \"password\": \"sarah1234\",\n" + //
                "    \"email\": \"sarah.doe@ucll.be\",\n" + //
                "    \"age\": 4\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Birgit Doe\",\n" + //
                "    \"password\": \"birgit1234\",\n" + //
                "    \"email\": \"birgit.doe@ucll.be\",\n" + //
                "    \"age\": 18\n" + //
                "  }\n" + //
                "]");
    }

    @Test
    public void givenAdultUsers_whenInvokingGetAdultUser_thenAdultUsersAreReturned() {
    client.get()
    .uri("/users/adults")
    .exchange()
    .expectStatus().is2xxSuccessful()
    .expectBody()
    .json("[\n" + //
                "  {\n" + //
                "    \"name\": \"John Doe\",\n" + //
                "    \"password\": \"john1234\",\n" + //
                "    \"email\": \"john.doe@ucll.be\",\n" + //
                "    \"age\": 25\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Jane Toe\",\n" + //
                "    \"password\": \"jane1234\",\n" + //
                "    \"email\": \"jane.toe@ucll.be\",\n" + //
                "    \"age\": 30\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Birgit Doe\",\n" + //
                "    \"password\": \"birgit1234\",\n" + //
                "    \"email\": \"birgit.doe@ucll.be\",\n" + //
                "    \"age\": 18\n" + //
                "  }\n" + //
                "]");

    }

    @Test
    public void givenUsersMinMax_whenInvokingGetUserMinMax_thenUsersMinMaxAreReturned() {
    client.get()
    .uri("/users/search/age/10/50")
    .exchange()
    .expectStatus().is2xxSuccessful()
    .expectBody()
    .json("[\n" + //
                "  {\n" + //
                "    \"name\": \"John Doe\",\n" + //
                "    \"password\": \"john1234\",\n" + //
                "    \"email\": \"john.doe@ucll.be\",\n" + //
                "    \"age\": 25\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Jane Toe\",\n" + //
                "    \"password\": \"jane1234\",\n" + //
                "    \"email\": \"jane.toe@ucll.be\",\n" + //
                "    \"age\": 30\n" + //
                "  },\n" + //
                "  {\n" + //
                "    \"name\": \"Birgit Doe\",\n" + //
                "    \"password\": \"birgit1234\",\n" + //
                "    \"email\": \"birgit.doe@ucll.be\",\n" + //
                "    \"age\": 18\n" + //
                "  }\n" + //
                "]");
    }

    @Test
    public void givenUsersLoan_whenInvokingGetUserLoan_thenUsersLoanAreReturned() {
    client.get()
    .uri( "/users/john.doe@ucll.be/loans")
    .exchange()
    .expectStatus().is2xxSuccessful()
    .expectBody()
    .json("[]");
    }

    @Test
    public void givenNewUser_whenInvokingPost_thenUserIsSaved() { 
    client.post()
    .uri("/users")
    .header("Content-Type", "application/json") 
    .bodyValue("{\n" + //
                "  \"name\": \"kylie Doe\",\n" + //
                "    \"password\": \"kylie1234\",\n" + //
                "    \"email\": \"kylie.doe@ucll.be\",\n" + //
                "    \"age\": 20\n" + //
                "}") 
    .exchange()
    .expectStatus().is2xxSuccessful()
    .expectBody()
    .json("{\n" + //
                "  \"name\": \"kylie Doe\",\n" + //
                "  \"password\": \"kylie1234\",\n" + //
                "  \"email\": \"kylie.doe@ucll.be\",\n" + //
                "  \"age\": 20\n" + //
                "}");
        // User newUser = new User("kylie Doe", "kylie1234",  "kylie.doe@ucll.be", 20);
        // assertEquals(true, userService.findUserByName(newUser.getName()));
     }

     @Test
    public void givenPutUser_whenInvokingPut_thenUserIsSaved() { 
    client.put()
    .uri("/users/john.doe@ucll.be")
    .header("Content-Type", "application/json") 
    .bodyValue("{\n" + //
                "  \"name\": \"john Doe\",\n" + //
                "    \"password\": \"john1234\",\n" + //
                "    \"email\": \"john.doe@ucll.be\",\n" + //
                "    \"age\": 20\n" + //
                "}")
    .exchange()
    .expectStatus().is2xxSuccessful()
    .expectBody()
    .json("{\n" + //
                "  \"name\": \"john Doe\",\n" + //
                "  \"password\": \"john1234\",\n" + //
                "  \"email\": \"john.doe@ucll.be\",\n" + //
                "  \"age\": 20\n" + //
                "}");
    }

}
