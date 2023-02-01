package inter_rao.online_shop.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Модель склада
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    private Integer quantity;
    @OneToMany
    @JoinColumn(name = "item_id")
    private List<Item> items;

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Warehouse() {
    }
}