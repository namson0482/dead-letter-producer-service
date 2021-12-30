package son.vu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillRememberTransactionDTO {

	private String customerCode;

	private String guId;

	private String supplierCode;

	private String paymentServiceCode;

	private String customerId;
}
