package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Clerk extends Actor {

	private Collection<Orderr> order;

	@OneToMany(mappedBy = "clerk")
	public Collection<Orderr> getOrder() {
		return order;
	}
	public void setOrder(Collection<Orderr> order) {
		this.order = order;
	}


}
