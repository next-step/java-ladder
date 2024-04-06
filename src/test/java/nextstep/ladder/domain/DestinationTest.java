package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DestinationTest {

    @Test
    @DisplayName("실행결과가 null 또는 ''일 경우에 예외(null => IllegalArgumentException, '' => IllegalArgumentException)")
    void null_or_empty() {
        assertThatThrownBy(() -> {
            new Destination(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Destination("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
