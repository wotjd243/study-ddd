package io.github.wotjd243.dddpokemon.pokemon.ui;

import io.github.wotjd243.dddpokemon.pokemon.application.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatchingRestController {
    // TODO (1) CatchingRestControllerTest 만들기
    // TODO (2) 클래스명 위에 @RunWith(SpringRunner.class) 추가하기
    // TODO (3) 클래스명 위에 @SpringBootTest 추가하기
    // TODO (4) 클래스명 위에  @AutoConfigureMockMvc 추가하기
    // TODO (5) MockMvc 주입하기
    // TODO (6) CatchingRestControllerTest 단위 테스트
    private PokemonService pokemonService;

    public CatchingRestController(final PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/catch/{number}")
    public boolean tryCatch(
            @PathVariable int number
    ) {
        return pokemonService.catchPokemon(number);
    }
}
