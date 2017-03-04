package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "capital")
@XmlAccessorType(XmlAccessType.FIELD)
public class Capital {

	@XmlElement(name = "id")
	private int id;
	@XmlElement
	private String name;
	@XmlElement
	private int population;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Capital capital = (Capital) o;

		if (id != capital.id) return false;
		if (population != capital.population) return false;
		return name != null ? name.equals(capital.name) : capital.name == null;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + population;
		return result;
	}

	@Override
	public String toString() {
		return "Capital{" +
				"id=" + id +
				", name='" + name + '\'' +
				", population=" + population +
				'}';
	}
}
