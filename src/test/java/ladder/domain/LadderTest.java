package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("사다리 높이와 한 층의 기둥수(== 사다리 게임 참가자 수)로 사다리(Ladder)를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"5,4", "10,5", "10,10"})
    void create(int ladderHeight, int countOfPillar) {
        Ladder ladder = new Ladder(ladderHeight, countOfPillar, () -> true); // MovingStrategy 테스트는 FloorTest 참조
        assertThat(ladder.getFloors().size()).isEqualTo(ladderHeight);
        assertThat(ladder.getFloors().get(0).getLines().size()).isEqualTo(countOfPillar);
    }
}
