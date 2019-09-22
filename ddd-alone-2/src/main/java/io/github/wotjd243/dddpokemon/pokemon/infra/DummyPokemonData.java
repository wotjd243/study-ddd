package io.github.wotjd243.dddpokemon.pokemon.infra;

import io.github.wotjd243.dddpokemon.pokemon.domain.NationalPokedexNumber;
import io.github.wotjd243.dddpokemon.pokemon.domain.Pokemon;

import java.util.HashMap;
import java.util.Map;

public class DummyPokemonData {
    private static final Map<NationalPokedexNumber, Pokemon> data = new HashMap<>();

    static {
        put(1, "이상해씨", 45);
        put(2, "이상해풀", 45);
        put(3, "이상해꽃", 45);
        put(4, "파이리", 45);
        put(5, "리자드", 45);
        put(6, "리자몽", 45);
        put(7, "꼬부기", 45);
        put(8, "어니부기", 45);
        put(9, "거북왕", 45);
        put(10, "캐터피", 255);
        put(11, "단데기", 120);
        put(12, "버터플", 45);
        put(13, "뿔충이", 255);
        put(14, "딱충이", 120);
        put(15, "독침붕", 45);
        put(16, "구구", 255);
        put(17, "피죤", 120);
        put(18, "피죤투", 45);
        put(19, "꼬렛", 255);
        put(20, "레트라", 127);
    }

    public static Pokemon get(final NationalPokedexNumber key) {
        return data.get(key);
    }

    private static Pokemon put(final int number, final String name, final int captureRate) {
        return data.put(NationalPokedexNumber.valueOf(number), new Pokemon(number, name, captureRate));
    }
}
