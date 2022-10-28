package ladder.domain.person;

import ladder.exception.person.PeopleSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PeopleTest {

    @Test
    void valid_size() {
        assertThatThrownBy(() -> new People("pobi")).isInstanceOf(PeopleSizeException.class);
    }
}
