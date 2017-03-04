package domain;

import javax.xml.bind.annotation.*;
import java.util.UUID;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressableCustomer {

	@XmlAttribute
	protected int id;

	@XmlElement(name = "name")
	protected String fullname;

	@XmlElement
	protected Address address;

	public AddressableCustomer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "AddressableCustomer{" +
				"id=" + id +
				", fullname='" + fullname + '\'' +
				", address=" + address +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AddressableCustomer customer = (AddressableCustomer) o;

		if (id != customer.id) return false;
		if (!fullname.equals(customer.fullname)) return false;
		return address.equals(customer.address);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + fullname.hashCode();
		result = 31 * result + address.hashCode();
		return result;
	}
}
