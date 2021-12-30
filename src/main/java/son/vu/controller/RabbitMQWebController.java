package son.vu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import son.vu.model.BillRememberTransactionDTO;
import son.vu.model.CardRequest;
import son.vu.model.Employee;
import son.vu.model.ErrorProcessingRequestMessageDTO;
import son.vu.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
@Slf4j
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping(value = "/process", method = RequestMethod.POST, consumes = "text/plain")
	public void process(@RequestBody String payload) throws Exception {
		rabbitMQSender.send(payload);
		log.info(payload);
	}

	@PostMapping(value = "/card_service")
	public String producer(@RequestBody CardRequest<? extends Object> cardRequest) throws JsonProcessingException {
		String result = rabbitMQSender.send(cardRequest);
		log.info("Messsage {}", objectMapper.writeValueAsString(cardRequest));
		return "Message sent to the RabbitMQ successfully with " + result;
	}

	@PostMapping(value = "/error_service")
	public String producer(@RequestBody ErrorProcessingRequestMessageDTO errorProcessingRequestMessageDTO)
			throws JsonProcessingException {
		String result = rabbitMQSender.send(errorProcessingRequestMessageDTO);
		log.info("Messsage {}", objectMapper.writeValueAsString(errorProcessingRequestMessageDTO));
		return "Message sent to the RabbitMQ successfully with " + result;
	}

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId,
			@RequestParam("salary") int salary) {
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setSalary(salary);
		rabbitMQSender.send(emp);
		return "Message sent to the RabbitMQ Successfully";
	}

	@PostMapping(value = "/feecharge_service")
	public String producerFeeCharge(@RequestBody ErrorProcessingRequestMessageDTO errorProcessingRequestMessageDTO)
			throws JsonProcessingException {
		String result = rabbitMQSender.sendFC(errorProcessingRequestMessageDTO);
		log.info("Messsage {}", objectMapper.writeValueAsString(errorProcessingRequestMessageDTO));
		return "Message sent to the RabbitMQ successfully with " + result;
	}
	
	@PostMapping(value = "/bill_remember")
	public String producerBillRemember(@RequestBody BillRememberTransactionDTO billRememberTransactionDTO)
			throws JsonProcessingException {
		rabbitMQSender.send(billRememberTransactionDTO);
		log.info("Messsage {}", objectMapper.writeValueAsString(billRememberTransactionDTO));
		return "Message sent to the RabbitMQ successfully with " + objectMapper.writeValueAsString(billRememberTransactionDTO);
	}
}
