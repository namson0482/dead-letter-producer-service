package son.vu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorProcessingRequestMessageDTO {

	String requestTypCd;
	
	long reqNbr;
	
	String errCode;
	
	String errMsg;
	
}
