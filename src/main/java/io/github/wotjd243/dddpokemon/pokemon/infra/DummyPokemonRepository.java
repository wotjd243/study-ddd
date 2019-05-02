package io.github.wotjd243.dddpokemon.pokemon.infra;

import io.github.wotjd243.dddpokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.dddpokemon.pokemon.domain.PokemonRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummyPokemonRepository implements PokemonRepository {
    @Override
    public Optional<Pokemon> findById(final NationalPokedexNumber id) {
        return Optional.ofNullable(DummyPokemonData.get(id));
    }
}
