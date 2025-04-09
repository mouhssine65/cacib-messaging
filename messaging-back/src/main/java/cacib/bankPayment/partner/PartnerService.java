package cacib.bankPayment.partner;

import java.util.List;

public interface PartnerService {
    List<PartnerDTO> getAllPartners();

    PartnerDTO getPartnerById( Long id );

    PartnerDTO createPartner( PartnerDTO partner );

    void deletePartner( Long id );
}
