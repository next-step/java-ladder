package ladder.domain;

import ladder.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("라인 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 4, 8})
    public void 라인_생성_테스트(int countOfPerson) {
        Line line1 = new Line(countOfPerson, new RandomLineCreateStrategy(new Random()));

        assertThat(line1.getPoints()).hasSize(countOfPerson -1);
    }
}
