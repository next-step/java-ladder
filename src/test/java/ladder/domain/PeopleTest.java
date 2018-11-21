package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {

    @Test
    public void 글자수_체크() {
        People people = People.from("1,2,3,4,5");
        assertThat(people.peopleCount()).isEqualTo(5);
    }
}