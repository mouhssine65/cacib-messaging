package partner;

import cacib.bankPayment.partner.Partner;
import cacib.bankPayment.partner.PartnerDTO;
import cacib.bankPayment.partner.PartnerRepository;
import cacib.bankPayment.partner.PartnerService;
import cacib.bankPayment.partner.PartnerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class)
public class PartnerServiceTest {

    @Mock
    private PartnerRepository partnerRepository;

    @InjectMocks
    private PartnerServiceImpl partnerService;

    @Test
    public void testGetAllPartners() {
        Partner partner1 = new Partner();
        partner1.setAlias( "Test Alias 1" );
        partner1.setType( "Test Type 1" );
        partner1.setDirection( "INBOUND" );
        partner1.setApplication( "Test Application 1" );
        partner1.setProcessedFlowType( "MESSAGE" );
        partner1.setDescription( "Test Description 1" );

        List<Partner> partners = List.of( partner1 );

        when(partnerRepository.findAll()).thenReturn(partners);

        List<PartnerDTO> result = partnerService.getAllPartners();
        assertEquals(1, result.size());
        verify(partnerRepository, times(1)).findAll();
    }

    @Test
    public void testGetPartnerById() {
        Partner partner1 = new Partner();
        partner1.setAlias( "Test Alias 1" );
        partner1.setType( "Test Type 1" );
        partner1.setDirection( "INBOUND" );
        partner1.setApplication( "Test Application 1" );
        partner1.setProcessedFlowType( "MESSAGE" );
        partner1.setDescription( "Test Description 1" );

        when(partnerRepository.findById(1L)).thenReturn(Optional.of(partner1));

        PartnerDTO result = partnerService.getPartnerById(1L);
        assertNotNull( result );
        verify(partnerRepository, times(1)).findById(1L);
    }

    @Test
    public void testDeletePartner() {
        doNothing().when(partnerRepository).deleteById(1L);

        partnerService.deletePartner(1L);
        verify(partnerRepository, times(1)).deleteById(1L);
    }
}
