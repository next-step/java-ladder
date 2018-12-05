import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
	@Test(expected = IllegalArgumentException.class)
	public void newPerson() {
		Person qqqqqqq = new Person("qqqqqqq");
	}
	
	
	@Test
	public void findByName() {
		String[] names = {"pobi", "honux", "crong", "jk"};
		List<Person> persons = Person.getPersons(names);
		Person honux = Person.findByName(persons, "honux");
		assertThat(honux.getName()).isEqualTo("honux");
	}
	
	@Test
	public void getResult() {
	
	}
	
	@Test
	public void isAll() {
		assertThat(Person.isAll("all")).isTrue();
	}
	
	@Test
	public void isAll_false() {
		assertThat(Person.isAll("honux")).isFalse();
	}
}