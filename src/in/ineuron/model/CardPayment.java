package in.ineuron.model;
import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "CARD_PAYMENT_TBSC")
@DiscriminatorValue("CARD")
@PrimaryKeyJoinColumn(name = "payment_id", referencedColumnName = "pid")
public class CardPayment extends Payment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long cardNo;
	private String cardType;
	private String paymenyGateway;
	
	
	public Long getCardNo() {	
		return cardNo;
	}

	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getPaymenyGateway() {
		return paymenyGateway;
	}

	public void setPaymenyGateway(String paymenyGateway) {
		this.paymenyGateway = paymenyGateway;
	}

	@Override
	public String toString() {
		return "CardPayment [cardNo=" + cardNo + ", cardType=" + cardType + ", paymenyGateway=" + paymenyGateway + "]";
	}
	
}
