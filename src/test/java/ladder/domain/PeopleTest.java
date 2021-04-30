package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PeopleTest {
    @Test
    public void create() {
        final String[] names = {"pobi", "honux", "crong", "jk"};

        assertThatCode(() -> new People(names))
                .doesNotThrowAnyException();
    }
}
