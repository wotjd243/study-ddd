package io.github.wotjd243.dddpokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    // COMPLETED (1) Trainer에 가지고 있는 포켓몬 리스트를 추가한다.
    // COMPLETED (2) Trainer AGGREGATE에 잡힌 포켓몬을 뜻하는 PokemonCaught VALUE OBJECT를 만든다.
    // COMPLETED (3) 가지고 있는 포켓몬 리스트는 Party라는 일급 콜렉션으로 만든다.
    // COMPLETED (4) Party와 PokemonCaught에 @Embeddable를 붙인다.
    // COMPLETED (5) Party가 가지고 있는 콜렉션에 @ElementCollection을 붙인다.
    // COMPLETED (6) Trainer의 party에 @Embedded를 붙인다.
}
