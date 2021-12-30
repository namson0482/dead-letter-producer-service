package son.vu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardRequest<T> {

	@JsonProperty("requestTypCd")
	private String requestTypCd;

	@JsonProperty("data")
	private T data;
	
}
