package nextstep.step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleTest {



    @Test
    void create() {
        People people = new People("peter,kassie");
        List<Person> newPeople = people.create("peter,kassie");
        assertThat(newPeople).contains(Person.of("peter"));
    }

    @Test
    void getSize() {
        People people = new People("peter,kassie");
        int size = people.getSize();
        assertThat(size).isEqualTo(2);
    }
}