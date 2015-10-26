package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Order extends DomainEntity{
	private String ticker;
	private Date placementMoment;
	private String address;
	private Date deliveryMoment;
	private Date cancelMoment;
	private CreditCard creditCard;
	private Clerk clerk;
	private Collection<OrderItem> orderItem;
	private Consumer consumer;
	
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^\\d{6}\\-\\w{4}$")
	@Valid
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	@NotNull
	public Date getPlacementMoment() {
		return placementMoment;
	}
	public void setPlacementMoment(Date placementMoment) {
		this.placementMoment = placementMoment;
	}
	
	@NotBlank
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getDeliveryMoment() {
		return deliveryMoment;
	}
	public void setDeliveryMoment(Date deliveryMoment) {
		this.deliveryMoment = deliveryMoment;
	}
	
	public Date getCancelMoment() {
		return cancelMoment;
	}
	public void setCancelMoment(Date cancelMoment) {
		this.cancelMoment = cancelMoment;
	}
	
	@Valid
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	
	@ManyToOne(optional = true)
	public Clerk getClerk() {
		return clerk;
	}
	public void setClerk(Clerk clerk) {
		this.clerk = clerk;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "order")
	public Collection<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(Collection<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	@Valid
	@NotNull
	@ManyToOne(optional = false)
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	
}
