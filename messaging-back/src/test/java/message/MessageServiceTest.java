package message;

import cacib.bankPayment.message.Message;
import cacib.bankPayment.message.MessageDto;
import cacib.bankPayment.message.MessageRepository;
import cacib.bankPayment.message.MessageServiceImpl;
import cacib.bankPayment.partner.Partner;
import cacib.bankPayment.partner.PartnerDTO;
import cacib.bankPayment.partner.PartnerRepository;
import cacib.bankPayment.partner.PartnerServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith( MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageServiceImpl messageService;

    @Test
    public void testReceiveMessage() {
        String messageContent = "Hello World!";
        Message message = new Message();
        message.setContent(messageContent);

        messageService.receiveMessage(messageContent);

        verify(messageRepository, times(1)).save(any(Message.class));
    }

    @Test
    public void testGetAllMessages() {
        Message message1 = new Message();
        message1.setId(1L);
        message1.setContent("Message 1");

        Message message2 = new Message();
        message2.setId(2L);
        message2.setContent("Message 2");

        when(messageRepository.findAll()).thenReturn( Arrays.asList( message1, message2 ) );

        List<MessageDto> messages = messageService.getAllMessages();

        assertEquals(2, messages.size());
        assertEquals("Message 1", messages.get(0).content());
        assertEquals("Message 2", messages.get(1).content());
    }

    @Test
    public void testGetMessageById() {
        Long id = 1L;
        Message message = new Message();
        message.setId(id);
        message.setContent("Message Content");

        when(messageRepository.findById(id)).thenReturn(Optional.of(message));

        Message result = messageService.getMessageById(id);

        assertEquals(id, result.getId());
        assertEquals("Message Content", result.getContent());
    }

}
