package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    public static final Ladder LADDER = Ladder.of(3, 5, () -> PartLineTest.TRUE);
    
    @DisplayName("사다리 이동")
    @ParameterizedTest(name = "{displayName} : currentPosition => {0}, resultPosition => {1}")
    @CsvSource(value = {"4, 4", "3, 2", "2, 3", "1, 0", "0, 1"})
    void move(int currentPosition, int resultPosition) {
        assertThat(LADDER.move(currentPosition)).isEqualTo(resultPosition);
    }
}
