package inter_rao.online_shop.Controller;


import inter_rao.online_shop.Service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * Контроллер для работы с товарами
 */

@Slf4j
@RestController
@RequestMapping("item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
}

