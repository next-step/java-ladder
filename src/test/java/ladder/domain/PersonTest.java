package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonTest {
    @Test
    public void create() {
        assertThat(new Person("crong")).isEqualTo(new Person("crong"));
    }

    @Test
    public void create_longerThan5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Person("longer");
        });
    }
}