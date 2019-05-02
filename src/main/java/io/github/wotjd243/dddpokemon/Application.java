package io.github.wotjd243.dddpokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // COMPLETED (1) pokemon > ui > CatchingRestController 만들기
        // COMPLETED (2) 생성자를 통해 PokemonService를 주입 받도록 구현
        // COMPLETED (3) @GetMapping("/pokemon/catch/{number}")를 사용하여 pokemonService의 catchPokemon()를 실행하도록 구현
        // COMPLETED (4) CatchingRestController를 컴포넌트로 등록하기
    }
}
