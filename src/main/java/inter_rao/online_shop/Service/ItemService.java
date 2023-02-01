package inter_rao.online_shop.Service;

import inter_rao.online_shop.Entity.Item;

import java.util.List;

public interface ItemService {


    List<Item> getAllItems();

    void delete(Item item);

}
