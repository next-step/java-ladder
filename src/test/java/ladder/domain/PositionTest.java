package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @DisplayName("해당 Index를 가진 Position 이 만들어진다.")
    @Test
    public void createTest() {
        Position position = Position.of(3);

        assertThat(position).isNotNull();
        assertThat(position.get()).isEqualTo(3);
    }

    @DisplayName("다음 포지션을 리턴한다.")
    @ParameterizedTest
    @CsvSource({"1, 0", "0, 1"})
    public void nextPositionTest(String startIndex, String nextIndex) {
        Position position = Position.of(Integer.parseInt(startIndex));
        HorizonLine horizonLine = new HorizonLine(4, () -> true);

        Position nextPosition  = position.next(horizonLine);
        assertThat(nextPosition.toString()).isEqualTo(nextIndex);

    }
}
