package inter_rao.online_shop.Entity;

import jakarta.persistence.*;
import lombok.*;
/**
 * Модель покупателя
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Buyer() {
    }
}
