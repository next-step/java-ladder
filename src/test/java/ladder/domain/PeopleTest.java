package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {

    @Test
    public void 사람들_count() {
        People people = new People("pobi,honux,crong,jk");
        assertThat(people.peopleCount()).isEqualTo(4);

    }

}