package son.vu.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
import son.vu.config.properties.AppProperties;
import son.vu.model.BillRememberTransactionDTO;
import son.vu.model.CardRequest;
import son.vu.model.Employee;
import son.vu.model.ErrorProcessingRequestMessageDTO;

@Service
@Slf4j
public class RabbitMQSender {

	private final AppProperties appProperties;

	private final RabbitTemplate rabbitTemplate;
	
	@Autowired
	public RabbitMQSender(RabbitTemplate rabbitTemplate, AppProperties appProperties) {

		this.rabbitTemplate = rabbitTemplate;
		this.appProperties = appProperties;
	}

	public String send(CardRequest<? extends Object> cardRequest) {
		rabbitTemplate.convertAndSend(appProperties.getRabbitmq().getExchange(),
				appProperties.getRabbitmq().getCreateVdcQueue(), cardRequest);
		return String.format(Messages.getString("RabbitMQSender.0"), appProperties.getRabbitmq().getExchange(), //$NON-NLS-1$
				appProperties.getRabbitmq().getCreateVdcQueue());
	}

	public void send(Employee employee) {
		rabbitTemplate.convertAndSend(appProperties.getRabbitmq().getExchange(),
				appProperties.getRabbitmq().getCreateVdcQueue(), employee);
	}

	public String send(ErrorProcessingRequestMessageDTO errorProcessingRequestMessageDTO) throws JsonProcessingException {

		rabbitTemplate.convertAndSend(appProperties.getRabbitmq().getExchange(),
				appProperties.getRabbitmq().getErrorVdcQueue(), errorProcessingRequestMessageDTO);
		return String.format(Messages.getString("RabbitMQSender.0"), appProperties.getRabbitmq().getExchange(), //$NON-NLS-1$
				appProperties.getRabbitmq().getErrorVdcQueue());
	}
	
	public void send(String str) {
		rabbitTemplate.convertAndSend(appProperties.getRabbitmq().getExchange(),
				appProperties.getRabbitmq().getCreateVdcQueue(), str);
	}

	public String sendFC(ErrorProcessingRequestMessageDTO errorProcessingRequestMessageDTO) {
		rabbitTemplate.convertAndSend(appProperties.getRabbitmq().getExchange(),
				appProperties.getRabbitmq().getFeeChargeQueue(), errorProcessingRequestMessageDTO);
		return String.format(Messages.getString("RabbitMQSender.0"), appProperties.getRabbitmq().getExchange(), //$NON-NLS-1$
				appProperties.getRabbitmq().getFeeChargeQueue());
	}
	
	public void send(BillRememberTransactionDTO billRemember) {
		rabbitTemplate.convertAndSend(appProperties.getRabbitmq().getExchange(),
				appProperties.getRabbitmq().getCreateVdcQueue(), billRemember);
	}
}