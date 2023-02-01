package inter_rao.online_shop.Entity;

import jakarta.persistence.*;
import lombok.*;
/**
 * Модель продавца
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Seller() {
    }
}