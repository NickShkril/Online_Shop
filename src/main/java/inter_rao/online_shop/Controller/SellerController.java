package inter_rao.online_shop.Controller;

import inter_rao.online_shop.Entity.Seller;
import inter_rao.online_shop.Service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Контроллер для работы с продавцами
 */

@Slf4j
@RestController
@RequestMapping("seller")
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }


    // Получить всех продавцов
    @GetMapping("getAll")
    public List<Seller> getAllSellers() {
        log.info("Was invoked seller controller method to get all sellers");
        return sellerService.getAllSellers();
    }

    // Получить информацию о продавце по id
    @GetMapping("find/{id}")
    public Optional<Seller> findSellerById(@PathVariable Long id) {
        log.info("Was invoked seller controller method to find seller by id");
        return sellerService.getSellerById(id);
    }



}
