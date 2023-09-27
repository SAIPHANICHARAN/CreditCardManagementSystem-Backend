package com.sunku.sg.creditcardms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sunku.sg.creditcardms.model.CreditCardRequest;

@Entity
@Table(name = "CREDIT_CARD_REQUEST")
public class CreditCardRequestEntity {

	@Id
    @Column(name = "ID", nullable = false)
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private Integer id;
	
	@Column(name = "REQUEST_ID", nullable = false)
	private String requestId;
	
	@Column(name = "CUSTOMER_ID", nullable = false)
	private String customerId;
	
	@Column(name = "CARD_TYPE", nullable = false)
	private String cardType;
	
	@Column(name = "REQ_STATUS", nullable = false)
	private String status;
	
	@Column(name = "AGENT_ID")
	private String agentId;
	
	@Column(name = "REQUESTED_DATE", nullable = false)
	private String requestedDate;
	
	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	
	public CreditCardRequestEntity(CreditCardRequest creditCardRequest) {
		this.customerId= creditCardRequest.getCustomerId();
		this.cardType = creditCardRequest.getCardType();
		this.agentId = creditCardRequest.getAgentId();
		this.requestedDate =creditCardRequest.getRequestedDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
