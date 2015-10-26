package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class WareHouse extends DomainEntity{


	// Constructors -----------------------------------------------------------

	// Attributes -------------------------------------------------------------
	private String name;
	private String address;
	
	@NotBlank
	@NotNull
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank
	@NotNull
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	// Relationships ----------------------------------------------------------
	private Collection<Storage> storage;
	
	@Valid
	@OneToMany(mappedBy = "wareHouse")
	public Collection<Storage> getStorage() {
		return storage;
	}
	public void setStorage(Collection<Storage> storage) {
		this.storage = storage;
	}
	

}
