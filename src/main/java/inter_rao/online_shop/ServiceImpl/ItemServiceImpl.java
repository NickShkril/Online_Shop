package inter_rao.online_shop.ServiceImpl;

import inter_rao.online_shop.Entity.Item;
import inter_rao.online_shop.Repository.ItemRepository;
import inter_rao.online_shop.Service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс для работы с товарами
 */
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }
}

