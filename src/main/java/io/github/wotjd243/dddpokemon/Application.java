package io.github.wotjd243.dddpokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // COMPLETED (1) pokemon > application > PokemonService 만들기
        // COMPLETED (2) 생성자를 통해 PokemonRepository를 주입 받도록 구현
        // COMPLETED (3) 전국 도감 번호를 입력받아 Pokemon을 조회해오는 기능 구현
        // COMPLETED (4) 조회해온 Pokmon으로 CatchingService를 생성하여 isCaught()를 반환하도록 구현
        // COMPLETED (5) PokemonService를 컴포넌트로 등록하기
    }
}
