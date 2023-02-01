package inter_rao.online_shop.ServiceImpl;

import inter_rao.online_shop.Entity.Seller;
import inter_rao.online_shop.Repository.SellerRepository;
import inter_rao.online_shop.Service.SellerService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Класс для работы с продавцами
 */
@Slf4j
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @PostConstruct
    @Override
    public void initializeSellers() {
        List<Seller> sellerList = List.of(
                new Seller(null, "Иван"),
                new Seller(null, "Никита")
        );
        sellerRepository.saveAll(sellerList);
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Optional<Seller> getSellerById(Long id) {
        return sellerRepository.findById(id);
    }
}
