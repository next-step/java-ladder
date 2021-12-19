package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Height height = new Height(5);
        Ladder ladder = Ladder.of(4, height, () -> true);

        assertThat(ladder).isNotNull();
        assertThat(ladder.getLadder().size()).isEqualTo(height.getValue());
    }

    @DisplayName("사다리 탐색 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:4:4:2", "1:5:1:1", "2:5:2:1", "2:5:3:2"}, delimiter = ':')
    void discoveryLadder(int depth, int width, int startLine, int arrivalLocation) {
        Height height = new Height(depth);
        Ladder ladder = Ladder.of(width, height, () -> true);

        assertThat(ladder.discovery(startLine)).isEqualTo(arrivalLocation);
    }
}
