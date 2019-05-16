package io.github.wotjd243.dddpokemon.pokemon.ui;

import io.github.wotjd243.dddpokemon.pokemon.application.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatchingRestController {
    private PokemonService pokemonService;

    public CatchingRestController(final PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/catch/{number}")
    public boolean tryCatch(
            @PathVariable int number
            // TODO (13) 트레이너 아이디를 @RequestParam 으로 추가
            // TODO (14) 아이템 아이디를 @RequestParam 으로 추가
    ) {
        return pokemonService.catchPokemon(number);
        // TODO (15) catchPokemon() 수정
    }
}
