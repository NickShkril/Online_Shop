package inter_rao.online_shop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Warehouse is empty")
public class WarehouseIsEmpty extends RuntimeException {
    public WarehouseIsEmpty(String message) {
        super(message);
    }
}