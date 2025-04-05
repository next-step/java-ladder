package ladder;

import ladder.domain.People;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class PeopleTest {
    @Test
    void 이름_길이_예외() {
        assertThatThrownBy(() -> new People("finnnnnn,foo"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
