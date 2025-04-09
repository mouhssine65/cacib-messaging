package cacib.bankPayment.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class JmsMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String message) {
        Message msg = new Message();
        msg.setContent(message);
        messageRepository.save(msg);
    }
}
