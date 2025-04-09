package cacib.bankPayment;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queue")
public class IbmMQControllerMock {

    private final JmsTemplate jmsTemplate;

    public IbmMQControllerMock( final JmsTemplate jmsTemplate ) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping("send")
    @Operation(summary = "Send a message to the JMS queue")
    public String send(@RequestParam( name = "message", defaultValue = "Hello World!") String message ) {
        jmsTemplate.convertAndSend("DEV.QUEUE.1", message);
        return "OK";
    }

}
