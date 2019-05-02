package io.github.wotjd243.dddpokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // COMPLETED (1) pokemon > domain > Pokemon REPOSITORY 인터페이스 만들기
        // COMPLETED (2) infra > DummyPokemonData을 사용하는 Pokemon REPOSITORY 구현체 만들기
    }
}
