package inter_rao.online_shop.Service;

import inter_rao.online_shop.Entity.Item;
import inter_rao.online_shop.Entity.Warehouse;
import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;

public interface WarehouseService {
    @PostConstruct
    List<Item> initializeItems();

    List<Warehouse> getAllItems();

    Optional<Item> getItemById(Long id);


    Warehouse findByItemsContaining(Item item);

    void save(Warehouse warehouse);

}