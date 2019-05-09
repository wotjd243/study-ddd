package io.github.wotjd243.dddpokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    // COMPLETED (1) trainer > domain에 Trainer라는 ENTITY를 만든다.
    // COMPLETED (2) Trainer는 아이디와 레벨을 가진다.
    // COMPLETED (3) Trainer에 @Entity를 붙인다.
    // COMPLETED (4) @Id를 이용해서 식별자를 지정한다.
    // COMPLETED (4) trainer > domain에 TrainerRepository를 만든다.
    // COMPLETED (5) trainer > infra에 TrainerRepository를 구현한 JpaTrainerRepository를 만든다.
}
