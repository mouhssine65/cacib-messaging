package cacib.bankPayment.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @JmsListener(destination = "DEV.QUEUE.1")
    public void receiveMessage(String message) {
        Message msg = new Message();
        msg.setContent( message );
        messageRepository.save(msg);
    }

    public List<MessageDto> getAllMessages() {
       return messageRepository.findAll().stream()
                       .map(this::toDto)
                       .toList();
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }


    private MessageDto toDto(Message message) {
        return MessageDto.builder()
                         .id(message.getId())
                         .content(message.getContent())
                         .build();
    }

}
