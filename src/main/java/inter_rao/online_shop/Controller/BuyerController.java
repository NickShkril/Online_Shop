package inter_rao.online_shop.Controller;

import inter_rao.online_shop.Entity.Buyer;
import inter_rao.online_shop.Service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для работы с покупателями
 */
@Slf4j
@RestController
@RequestMapping("buyer")
public class BuyerController {
    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    private final BuyerService buyerService;

    // Получить всех покупателей
    @GetMapping("getAll")
    public List<Buyer> getAllBuyers() {
        log.info("Was invoked getAllBuyers method from buyer controller");
        return buyerService.getAllBuyers();
    }

    // Получить информацию о покупателе по id
    @GetMapping("find/{id}")
    public Optional<Buyer> findById(@PathVariable Long id) {
        log.info("Was invoked findById method from buyer controller");
        return buyerService.getBuyerById(id);
    }
}
