package com.sunku.sg.creditcardms.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunku.sg.creditcardms.entity.CreditCardRequestEntity;
import com.sunku.sg.creditcardms.model.CreditCardRequest;
import com.sunku.sg.creditcardms.repository.CrediCardRequestRepository;
import com.sunku.sg.creditcardms.utils.Constants;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ccms")
public class CrediCardMSController {

	@Autowired
	CrediCardRequestRepository creditCardRequestRepository;
	
	
	@ApiOperation(value = "API for requesting Credit Card", notes = "API will take channelId in the header and the Credit Card Request in the body")
	@RequestMapping(value = "/request/creditcard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> requestCreditCard(@RequestHeader(value = "channel") String channel,
			@Validated @RequestBody CreditCardRequest creditCardRequest) {
		if(null != creditCardRequest) {
			CreditCardRequestEntity entity= new CreditCardRequestEntity(creditCardRequest);
			entity.setRequestId(UUID.randomUUID().toString());
			entity.setStatus(Constants.STATUS_REQUESTED);
			creditCardRequestRepository.save(entity);
			return ResponseEntity.status(HttpStatus.CREATED).body("Your Request is received successfully. Keep this Request Id for reference : "+entity.getRequestId());
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Refer Swagger Documentation and give correct Request");
		}
	}

}
