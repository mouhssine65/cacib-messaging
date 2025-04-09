package cacib.bankPayment.partner;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;


@Builder
public record PartnerDTO(
        Long id,
        @NotBlank(message = "Alias is required") String alias,
        @NotBlank(message = "Type is required") String type,
        @NotNull(message = "Direction is required") Direction direction,
        @NotBlank(message = "Application is required") String application,
        @NotNull(message = "Processed Flow Type is required") ProcessedFlowType processedFlowType,
        @NotBlank(message = "Description is required") @Size( max = 255, message = "Description must be less than 255 characters") String description
) {
    public enum Direction {
        INBOUND, OUTBOUND
    }

    public enum ProcessedFlowType {
        MESSAGE, ALERTING, NOTIFICATION
    }

}
