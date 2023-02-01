package inter_rao.online_shop.Service;

import inter_rao.online_shop.Entity.Buyer;
import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;

public interface BuyerService {
    @PostConstruct
    void initializeBuyers();

    List<Buyer> getAllBuyers();

    Optional<Buyer> getBuyerById(Long id);
}
