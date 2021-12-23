package ladder.domain;

import ladder.strategy.RandomGeneratorStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("사다리 기둥수(== 사다리 게임 참가자 수)와 높이로 사다리(Ladder)를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"4,5", "5,10", "10,10"})
    void create(int countOfPillar, int ladderHeight) {
        Ladder ladder = new Ladder(countOfPillar, ladderHeight, new RandomGeneratorStrategy()); // GeneratorStrategy 테스트는 FloorTest 참조
        assertThat(ladder.getLadderLines().size()).isEqualTo(ladderHeight);
        assertThat(ladder.getLadderLines().get(0).getPoints().size()).isEqualTo(countOfPillar);
    }
}
