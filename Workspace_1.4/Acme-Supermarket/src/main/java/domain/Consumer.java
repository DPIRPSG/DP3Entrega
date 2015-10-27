package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
	private Collection<Orderr> order;
	
	@OneToOne(optional = true, mappedBy = "consumer")
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	@Valid
	@OneToMany(mappedBy = "consumer")
	public Collection<Orderr> getOrder() {
		return order;
	}
	public void setOrder(Collection<Orderr> order) {
		this.order = order;
	}
	

}
