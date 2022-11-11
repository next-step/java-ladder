package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NamesTest {
    @Test
    void invalid_size() {
        assertThatIllegalArgumentException().isThrownBy(() -> Names.of(List.of()));
        assertThatIllegalArgumentException().isThrownBy(() -> Names.of(List.of("name")));
    }
}
