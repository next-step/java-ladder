package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {
    @Test
    public void create() {
        assertThat(new Name("crong")).isEqualTo(new Name("crong"));
    }

    @Test
    public void create_longerThan5() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("longer");
        });
    }
}