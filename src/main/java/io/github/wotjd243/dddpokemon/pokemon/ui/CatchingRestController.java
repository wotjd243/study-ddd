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
    ) {
        return pokemonService.catchPokemon(number);
    }
}
