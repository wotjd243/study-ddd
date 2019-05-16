package io.github.wotjd243.dddpokemon.pokemon.infra;

import io.github.wotjd243.dddpokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.dddpokemon.pokemon.domain.PokemonRepository;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PokemonApiClient implements PokemonRepository {
    private static final PokeApiClient POKE_API_CLIENT = new PokeApiClient();

    private final PokemonTranslator pokemonTranslator;

    public PokemonApiClient(final PokemonTranslator pokemonTranslator) {
        this.pokemonTranslator = pokemonTranslator;
    }

    @Override
    public Optional<Pokemon> findById(final NationalPokedexNumber id) {
        final PokemonSpecies pokemonSpecies = POKE_API_CLIENT.getPokemonSpecies(id.getNumber());
        return pokemonTranslator.translate(pokemonSpecies);
    }
}
