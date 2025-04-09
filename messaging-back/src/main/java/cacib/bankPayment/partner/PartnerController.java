package cacib.bankPayment.partner;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * REST controller for managing partners.
 */
@RestController
@RequestMapping("/api/partners")
@Validated
@Tag(name = "partner", description = "API for managing partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    /**
     * Retrieves all partners.
     *
     * @return a list of PartnerDTO objects
     */
    @Operation(summary = "View a list of available partners")
    @GetMapping
    public List<PartnerDTO> getAllPartners() {
        return partnerService.getAllPartners();
    }

    /**
     * Retrieves a partner by ID.
     *
     * @param id the ID of the partner
     * @return the PartnerDTO object
     */
    @Operation(summary = "Get a partner by ID")
    @GetMapping("/{id}")
    public PartnerDTO getPartnerById(@Parameter(description = "ID of the partner to be retrieved", required = true) @PathVariable Long id) {
        return partnerService.getPartnerById(id);
    }

    /**
     * Creates a new partner.
     *
     * @param partnerDTO the partner data
     * @return the created PartnerDTO object
     */
    @Operation(summary = "Create a new partner")
    @PostMapping
    public ResponseEntity<PartnerDTO> createPartner(@Parameter(description = "Partner data to be created", required = true) @Valid @RequestBody PartnerDTO partnerDTO) {
        return new ResponseEntity<>(partnerService.createPartner(partnerDTO), HttpStatus.CREATED);
    }

    /**
     * Deletes a partner by ID.
     *
     * @param id the ID of the partner to be deleted
     */
    @Operation(summary = "Delete a partner by ID")
    @DeleteMapping("/{id}")
    public void deletePartner(@Parameter(description = "ID of the partner to be deleted", required = true) @PathVariable Long id) {
        partnerService.deletePartner(id);
    }
}
