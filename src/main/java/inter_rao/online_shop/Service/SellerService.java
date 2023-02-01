package inter_rao.online_shop.Service;

import inter_rao.online_shop.Entity.Seller;
import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;

public interface SellerService {
    @PostConstruct
    void initializeSellers();

    List<Seller> getAllSellers();

    Optional<Seller> getSellerById(Long id);
}
