package inter_rao.online_shop.ServiceImpl;

import inter_rao.online_shop.Entity.Item;
import inter_rao.online_shop.Entity.Warehouse;
import inter_rao.online_shop.Repository.ItemRepository;
import inter_rao.online_shop.Repository.WarehouseRepository;
import inter_rao.online_shop.Service.WarehouseService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Класс для работы с складами
 */
@Slf4j
@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final ItemRepository itemRepository;
    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(ItemRepository itemRepository, WarehouseRepository warehouseRepository) {
        this.itemRepository = itemRepository;
        this.warehouseRepository = warehouseRepository;
    }

    @PostConstruct
    @Override
    public List<Item> initializeItems() {
        List<Item> items = List.of(
                new Item(null, "Ручка", 10.0),
                new Item(null, "Тетрадь", 20.0),
                new Item(null, "Карандаш", 30.0),
                new Item(null, "Обложка", 40.0),
                new Item(null, "Подставка", 50.0),
                new Item(null, "Учебник", 60.0),
                new Item(null, "Пенал", 70.0),
                new Item(null, "Рюкзак", 80.0),
                new Item(null, "Форма", 90.0),
                new Item(null, "Телефон", 100.0)
        );
        itemRepository.saveAll(items);
        Warehouse warehouse = new Warehouse();
        warehouse.setName("Main");
        warehouse.setQuantity(10);
        warehouse.setItems(items);
        warehouseRepository.save(warehouse);
        return items;
    }

    @Override
    public List<Warehouse> getAllItems() {
        return warehouseRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Warehouse findByItemsContaining(Item item) {
        return warehouseRepository.findByItemsContaining(item);
    }

    @Override
    public void save(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }
}



