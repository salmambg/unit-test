package info.leanix.unittest.seeder;

import info.leanix.unittest.model.Item;
import info.leanix.unittest.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataBaseSeeder {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseSeeder.class);
    @Autowired
    ItemRepository itemRepository;
    @EventListener
    public void seed(ContextRefreshedEvent event) {
        logger.info("insert course data");
        seedItemData();
        logger.info("finish insert course data");
    }

    private void seedItemData() {
        List<Item> items = new ArrayList<>();

        Item item1 = createItem(10001, "Item1", 10, 20);
        Item item2 = createItem(10002, "Item2", 5, 10);
        Item item3 = createItem(10003, "Item3", 15, 2);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        itemRepository.saveAll(items);
    }
    private Item createItem(int id, String name, int price, int quantity) {
        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);
        return item;
    }
}
