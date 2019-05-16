package io.github.wotjd243.dddpokemon.item.application;

import io.github.wotjd243.dddpokemon.item.domain.Item;
import io.github.wotjd243.dddpokemon.item.domain.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private ItemRepository itemRepository;

    public ItemService(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItem(final long id) {
        return itemRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new)
                ;
    }
}
