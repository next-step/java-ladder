package ladder.domain.person;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ResultPeopleTest {

    @Test
    void create() {
        ResultPeople actual = new ResultPeople(new People("pobi", "crong").people());
        ResultPeople expected = new ResultPeople(List.of(new Person("pobi", 0), new Person("crong", 1)));

        assertThat(actual).isEqualTo(expected);
    }
}
