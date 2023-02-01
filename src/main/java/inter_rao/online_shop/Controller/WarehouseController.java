package inter_rao.online_shop.Controller;
import inter_rao.online_shop.Entity.Buyer;
import inter_rao.online_shop.Entity.Item;
import inter_rao.online_shop.Entity.Seller;
import inter_rao.online_shop.Entity.Warehouse;
import inter_rao.online_shop.Exception.ItemNotFound;
import inter_rao.online_shop.Exception.WarehouseIsEmpty;
import inter_rao.online_shop.Service.BuyerService;
import inter_rao.online_shop.Service.ItemService;
import inter_rao.online_shop.Service.SellerService;
import inter_rao.online_shop.Service.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Контроллер для работы с складами
 */

@Slf4j
@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;
    private final ItemService itemService;
    private final BuyerService buyerService;
    private final SellerService sellerService;


    public WarehouseController(WarehouseService warehouseService, ItemService itemService, BuyerService buyerService, SellerService sellerService) {
        this.warehouseService = warehouseService;
        this.itemService = itemService;
        this.buyerService = buyerService;
        this.sellerService = sellerService;
    }

    // Получить список всех товаров на складе
    @GetMapping("getAll")
    public List<Warehouse> getAllItems() {
        log.info("Was invoked getAllItems method from warehouse controller");
        return warehouseService.getAllItems();
    }

    // Найти товар по артикулу
    @GetMapping("find/{id}")
    public Optional<Item> findItemById(@PathVariable Long id) {
        log.info("Was invoked FindItemById method from warehouse controller");
        if (warehouseService.getItemById(id).isEmpty()) {
            throw new RuntimeException("Товара с таким артикулом не найдено");
        }
        return warehouseService.getItemById(id);
    }

    // Метод для списания товара склада. Метод берет случайного покупателя и случайного продавца. Затем производит продажу и удаляет товар со склада.
    @PutMapping("/writeOff/{id}")
    public Item writeOff(@PathVariable Long id) {
        log.info("Was invoked writeOff method from warehouse controller");

        Item item = warehouseService.getItemById(id).orElseThrow(() -> new ItemNotFound("Предмет не найден"));

        Warehouse warehouse = warehouseService.findByItemsContaining(item);

        if (warehouse.getQuantity() < 1) {
            throw new WarehouseIsEmpty("На складе нет предметов");
        }

        List<Buyer> buyerList = buyerService.getAllBuyers();
        List<Seller> sellerList = sellerService.getAllSellers();

        Random random = new Random();
        Buyer buyer = buyerList.get(random.nextInt(buyerList.size()));
        Seller seller = sellerList.get(random.nextInt(sellerList.size()));

        warehouse.setQuantity(warehouse.getQuantity() - 1);

        warehouseService.save(warehouse);

        System.out.println("Товар: " + item.getName() + " был продан продавцом: " + seller.getName() + ", покупателю: " + buyer.getName());

        System.out.println(item.getName() + " был удален со склада");
        itemService.delete(item);
        return item;
    }
}
