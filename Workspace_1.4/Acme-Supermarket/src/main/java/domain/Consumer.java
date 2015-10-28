package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity
@Access(AccessType.PROPERTY)
public class Consumer extends Actor {

	// Constructors -----------------------------------------------------------

	// Attributes -------------------------------------------------------------
	
	// Relationships ----------------------------------------------------------
	private ShoppingCart shoppingCart;
	private Collection<Order> order;
	
	@Valid
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	@OneToMany(mappedBy = "consumer")
	public Collection<Order> getOrder() {
		return order;
	}
	public void setOrder(Collection<Order> order) {
		this.order = order;
	}
	

}
