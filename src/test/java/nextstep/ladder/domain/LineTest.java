package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @Test
    void create_연속된_true_값_불가() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(List.of(true, true, true)));
    }
}
