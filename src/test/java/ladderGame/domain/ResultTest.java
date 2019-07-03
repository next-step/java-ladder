package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("결과의 position 비교")
    void isEquals() {
        Result result = Result.of("1000", 2);
        assertThat(result.isEquals(new Position(2))).isTrue();
    }
}