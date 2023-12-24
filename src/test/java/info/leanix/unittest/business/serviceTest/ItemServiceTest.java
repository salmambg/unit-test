package info.leanix.unittest.business.serviceTest;

import info.leanix.unittest.model.Item;
import info.leanix.unittest.repository.ItemRepository;
import info.leanix.unittest.service.ItemService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

    @Test
    public void retrieveAllItems_basic() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,10),
                new Item(3,"Item3",20,20)));
        List<Item> items = itemService.retrieveAllItem();
        assertEquals(100,items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }
}
