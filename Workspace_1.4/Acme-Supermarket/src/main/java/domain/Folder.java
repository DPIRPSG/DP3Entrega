package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Folder extends DomainEntity{

	// Constructors -----------------------------------------------------------

	// Attributes -------------------------------------------------------------
	private String name;
	private boolean isSystem;
	
	@NotBlank
	@NotNull
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//Al ser primitivo no permite ser nulo
	public boolean getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}
	
	// Relationships ----------------------------------------------------------
	private Actor owner;
	private Collection<Message> message;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Actor getOwner() {
		return owner;
	}
	public void setOwner(Actor owner) {
		this.owner = owner;
	}
	
	@Valid
	@ManyToMany
	@NotNull
	public Collection<Message> getMessage() {
		return message;
	}
	public void setMessage(Collection<Message> message) {
		this.message = message;
	}
	

}
