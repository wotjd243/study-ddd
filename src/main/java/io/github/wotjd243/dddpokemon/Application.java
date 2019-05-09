package io.github.wotjd243.dddpokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    // TODO (1) trainer > domain에 Trainer라는 ENTITY를 만든다.
    // TODO (2) Trainer는 아이디와 레벨을 가진다.
    // TODO (3) Trainer에 @Entity를 붙인다.
    // TODO (4) @Id를 이용해서 식별자를 지정한다.
    // TODO (4) trainer > domain에 TrainerRepository를 만든다.
    // TODO (5) trainer > infra에 TrainerRepository를 구현한 JpaTrainerRepository를 만든다.
}
