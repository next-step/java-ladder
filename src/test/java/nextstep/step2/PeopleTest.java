package nextstep.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PeopleTest {

    People people;

    @BeforeEach
    void setUp() {
        people = new People("peter,kassie");
    }

    @Test
    void create() {
        List<Person> newPeople = people.create("peter,kassie");
        assertThat(newPeople).contains(Person.of("peter"));
    }

    @Test
    void getSize() {
        int size = people.getSize();
        assertThat(size).isEqualTo(2);
    }
}