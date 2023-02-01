package inter_rao.online_shop.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Item not found")
public class ItemNotFound extends RuntimeException {
    public ItemNotFound(String message) {
        super(message);
    }

}