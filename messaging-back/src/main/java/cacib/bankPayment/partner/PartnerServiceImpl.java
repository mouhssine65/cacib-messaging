package cacib.bankPayment.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/api/partners" )
@Validated
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public List<PartnerDTO> getAllPartners() {
        return partnerRepository.findAll().stream()
                                .map( this::toDto )
                                .toList();

    }

    public PartnerDTO getPartnerById( Long id ) {
        return partnerRepository.findById( id )
                                .map( this::toDto )
                                .get();
    }

    public PartnerDTO createPartner( PartnerDTO partner ) {
        Partner entity = toEntity( partner );
        Partner savedEntity = partnerRepository.save( entity );
        return toDto( savedEntity );
    }

    public void deletePartner( Long id ) {
        partnerRepository.deleteById( id );
    }


    private Partner toEntity( PartnerDTO partnerDTO ) {
        return Partner.builder()
                      .alias( partnerDTO.alias() )
                      .type( partnerDTO.type() )
                      .direction( partnerDTO.direction().name() )
                      .application( partnerDTO.application() )
                      .processedFlowType( partnerDTO.processedFlowType().name() )
                      .description( partnerDTO.description() )
                      .build();
    }

    private PartnerDTO toDto( Partner partner ) {
        return PartnerDTO.builder()
                         .id( partner.getId() )
                         .alias( partner.getAlias() )
                         .type( partner.getType() )
                         .direction( PartnerDTO.Direction.valueOf( partner.getDirection() ) )
                         .application( partner.getApplication() )
                         .processedFlowType( PartnerDTO.ProcessedFlowType.valueOf( partner.getProcessedFlowType() ) )
                         .description( partner.getDescription() )
                         .build();
    }

}
