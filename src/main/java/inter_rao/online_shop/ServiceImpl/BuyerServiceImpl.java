package inter_rao.online_shop.ServiceImpl;

import inter_rao.online_shop.Entity.Buyer;
import inter_rao.online_shop.Repository.BuyerRepository;
import inter_rao.online_shop.Service.BuyerService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Класс для работы с покупателями
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @PostConstruct
    @Override
    public void initializeBuyers() {
        List<Buyer> buyerList = List.of(
                new Buyer(null, "Виктор"),
                new Buyer(null, "Сергей"),
                new Buyer(null, "Стас"),
                new Buyer(null, "Даниил"),
                new Buyer(null, "Максим")
        );
        buyerRepository.saveAll(buyerList);
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public Optional<Buyer> getBuyerById(Long id)  {
        return buyerRepository.findById(id);
    }
}
