package io.github.wotjd243.dddpokemon.pokemon.application;

import io.github.wotjd243.dddpokemon.pokemon.domain.CatchingService;
import io.github.wotjd243.dddpokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;
import io.github.wotjd243.dddpokemon.pokemon.domain.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {
    private PokemonRepository pokemonRepository;

    public PokemonService(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public boolean catchPokemon(final int number) {
        final Pokemon pokemon = getPokemon(number);
        final CatchingService catchingService = new CatchingService(pokemon);
        return catchingService.isCaught();
    }

    private Pokemon getPokemon(final int number) {
    public Pokemon getPokemon(final int number) {
        return pokemonRepository.findById(NationalPokedexNumber.valueOf(number))
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
