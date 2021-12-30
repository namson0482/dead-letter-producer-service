package son.vu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrintCardServiceRequestBodyDTO {

	private long reqNbr;
	
	private long contractId;
	
	private double physicalCardPrintingFee;
	
}
