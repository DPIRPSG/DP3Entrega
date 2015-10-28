package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class ShoppingCart extends DomainEntity{

	// Constructors -----------------------------------------------------------

	// Attributes -------------------------------------------------------------
	private Collection<String> comment;
	
	@ElementCollection
	public Collection<String> getComment() {
		return comment;
	}
	public void setComment(Collection<String> comment) {
		this.comment = comment;
	}
	public boolean addComment(String e) {
		return comment.add(e);
	}
	public boolean removeComment(Object o) {
		return comment.remove(o);
	}
	
	// Relationships ----------------------------------------------------------
	private Consumer consumer;
	private Collection<Content> content;

	@Valid
	@NotNull
	@OneToOne(optional = false)
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	
	@OneToMany(mappedBy = "shoppingCart")
	public Collection<Content> getContent() {
		return content;
	}
	public void setContent(Collection<Content> content) {
		this.content = content;
	}
	
	
}
