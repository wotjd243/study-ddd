package io.github.wotjd243.dddpokemon.pokemon.domain;

import java.util.Optional;

public interface PokemonRepository {
    Optional<Pokemon> findById(final NationalPokedexNumber id);
}
