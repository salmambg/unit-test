package info.leanix.unittest.service;

import info.leanix.unittest.model.Item;
import info.leanix.unittest.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item retreiveHardCodedItem() {
        return new Item( 1,"Ball", 10,100);
    }

    public List<Item> retrieveAllItem() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice()* item.getQuantity());
        }
        return items;
    }
}
