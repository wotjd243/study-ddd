package io.github.wotjd243.dddpokemon.pokemon.infra;

import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import me.sargunvohra.lib.pokekotlin.model.Name;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PokemonTranslator {
    private static final int LANGUAGE_KOREAN_ID = 3;

    public Optional<Pokemon> translate(final PokemonSpecies pokemonSpecies) {
        final Pokemon pokemon = new Pokemon(
                pokemonSpecies.getId(),
                getName(pokemonSpecies.getNames(), LANGUAGE_KOREAN_ID, pokemonSpecies.getName()),
                pokemonSpecies.getCaptureRate()
        );
        return Optional.ofNullable(pokemon);
    }

    public String getName(final List<Name> names, final int languageId, final String defaultName) {
        return names.stream()
                .filter(name -> name.getLanguage().getId() == languageId)
                .findAny()
                .map(Name::getName)
                .orElse(defaultName)
                ;
    }
}
