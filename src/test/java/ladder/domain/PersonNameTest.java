package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PersonNameTest {
    @Test
    public void create() {
        assertThat(new PersonName("crong")).isEqualTo(new PersonName("crong"));
    }

    @Test
    public void create_longerThan5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PersonName("longer");
        });
    }
}