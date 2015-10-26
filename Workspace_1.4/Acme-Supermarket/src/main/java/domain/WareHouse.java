package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class WareHouse extends DomainEntity{

	private String name;
	private String address;
	private Collection<Storage> storage;
	
	@NotBlank
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Valid
	@OneToMany(mappedBy = "wareHouse")
	public Collection<Storage> getStorage() {
		return storage;
	}
	public void setStorage(Collection<Storage> storage) {
		this.storage = storage;
	}
	

}
