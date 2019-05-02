package io.github.wotjd243.dddpokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // TODO (1) RandomUtils.nextInt()를 이용하여 pokemon > domain > Catching SERVICE 만들기
        // TODO (2) CatchingServiceTest 만들기 및 단위 테스트
    }
}
