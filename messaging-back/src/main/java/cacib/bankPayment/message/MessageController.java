package cacib.bankPayment.message;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@Tag( name = "message", description = "API for managing messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    @Operation(summary = "View a list of available messages")
    public List<MessageDto> getAllMessages() {
        return messageService.getAllMessages();
    }

}
