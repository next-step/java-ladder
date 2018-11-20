package ladder.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {

    private String names;

    @Before
    public void setup() {
        names = "terry,carry,ashe,rose";
    }

    @Test
    public void 사람_여러명_이름_입력() {
        People people = People.of(names);

        assertThat(people.count()).isEqualTo(4);
    }
}
