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
}
