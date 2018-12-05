import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {
	private static final String ALL = "all";
	private static final int LIMIT_LENGTH = 5;
	private String name;
	
	public Person(String name) {
		if(name.length() > LIMIT_LENGTH) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static List<Person> getPersons(String[] split) {
		return Arrays.stream(split)
				.map(Person::new)
				.collect(Collectors.toList());
	}
	
	public static Person findByName(List<Person> persons, String name) {
		Person person = new Person(name);
		return persons.stream()
				.filter(p -> p.equals(person))
				.findAny()
				.orElseThrow(IllegalArgumentException::new);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	
	public static boolean isAll(String name) {
		return ALL.equals(name);
	}
}
