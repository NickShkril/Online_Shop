package inter_rao.online_shop.Repository;

import inter_rao.online_shop.Entity.Item;
import inter_rao.online_shop.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Warehouse findByItemsContaining(Item item);

    Warehouse save(Warehouse warehouse);
}
