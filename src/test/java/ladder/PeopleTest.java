package ladder;

import ladder.domain.People;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleTest {

    private People people;

    @BeforeEach
    void setUp() {
        people = new People("iron_man,black,pink,destroy");
    }


    @Test
    void 글자수_초과시_컬렉션_사이즈_테스트() {
        assertThat(people.getPeople()).hasSize(2);
    }
}
