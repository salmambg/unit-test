package info.leanix.unittest.service;

import info.leanix.unittest.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemService {
    public Item retreiveHardCodedItem() {
        return new Item( 1,"Ball", 10,100);
    }
}
