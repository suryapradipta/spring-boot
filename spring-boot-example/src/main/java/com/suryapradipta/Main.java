package com.suryapradipta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//SpringBootApplication is @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
// this spring web MVC
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // ("/") this the route API
    // this will send get request to the port 8080
    // this HTTP GET Request
    @GetMapping("/")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse("Hello",
            List.of("java", "golang", "javascript"),
            new Person("Surya", 21, 3000.5)
        );
        return response;
    }


    record Person(String name, int age, double savings) {
    }

    record GreetResponse(String greet,
                         List<String> favProgrammingLanguages,
                         Person person) {
    }

    /*
    {"greet":"Hello"}
    greet is instance (variable)
    Hello is actual value

    this result comes from get method

    */
    // this class the same as record method above
    /*class GreetResponse {
        private final String greet;

        GreetResponse(String greet) {
            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }

        @Override
        public String toString() {
            return "GreetResponse{" +
                "greet='" + greet + '\'' +
                '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GreetResponse)) return false;
            GreetResponse that = (GreetResponse) o;
            return Objects.equals(getGreet(), that.getGreet());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getGreet());
        }
    }*/
}
