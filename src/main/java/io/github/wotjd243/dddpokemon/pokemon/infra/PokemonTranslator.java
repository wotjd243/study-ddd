package io.github.wotjd243.dddpokemon.pokemon.infra;

import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PokemonTranslator {
    public Optional<Pokemon> translate(final PokemonSpecies pokemonSpecies) {
        final Pokemon pokemon = new Pokemon(
                pokemonSpecies.getId(),
                pokemonSpecies.getName(),
                pokemonSpecies.getCaptureRate()
        );
        return Optional.ofNullable(pokemon);
    }
}
