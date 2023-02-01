package inter_rao.online_shop.Entity;

import jakarta.persistence.*;
import lombok.*;
/**
 * Модель товара
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "item_id")
    private Long id;
    private String name;
    private Double price;

    public Item() {
    }
}

