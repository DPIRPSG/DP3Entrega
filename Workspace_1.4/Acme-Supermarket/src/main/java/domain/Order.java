package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
@Table(name = "orderTable")
public class Order extends DomainEntity{

	// Constructors -----------------------------------------------------------

	// Attributes -------------------------------------------------------------
	private String ticker;
	private Date placementMoment;
	private String address;
	private Date deliveryMoment;
	private Date cancelMoment;
	private CreditCard creditCard;
	
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^\\d{6}\\-\\w{4}$")
	@Valid
	@NotNull
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getPlacementMoment() {
		return placementMoment;
	}
	public void setPlacementMoment(Date placementMoment) {
		this.placementMoment = placementMoment;
	}
	
	@NotBlank
	@NotNull
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getDeliveryMoment() {
		return deliveryMoment;
	}
	public void setDeliveryMoment(Date deliveryMoment) {
		this.deliveryMoment = deliveryMoment;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
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
	
	
	// Relationships ----------------------------------------------------------
	private Clerk clerk;
	private Collection<OrderItem> orderItem;
	private Consumer consumer;
	
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
	@Size(min = 1)
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
