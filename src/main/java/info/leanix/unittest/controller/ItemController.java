package info.leanix.unittest.controller;

import info.leanix.unittest.model.Item;
import info.leanix.unittest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService businessService;
    @GetMapping("/dummy-item")
    public Item dummyItem () {
        return new Item( 1,"Ball", 10,100);
    }
    @GetMapping("/item-business-service")
    public Item ItemFromService () {
        return businessService.retreiveHardCodedItem();
    }

}
