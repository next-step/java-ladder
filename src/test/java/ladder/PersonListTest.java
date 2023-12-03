package ladder;

import ladder.domain.Person;
import ladder.domain.PersonList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PersonListTest {

    @Test
    void 객체_생성() {
        PersonList personList = new PersonList(Arrays.asList(new Person("p1", 0), new Person("p2", 1)));
        List<Person> persons = personList.getPersonList();

        assertThat(persons).hasSize(2);
    }

    @Test
    void 같은_이름_예외() {
        String[] personData = {"a", "a"};

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PersonList(personData));
    }
}