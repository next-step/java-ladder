package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.RandomConnectStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("사다리의 높이, 참여 인원 수, 연결 전략을 입력하면 사다리가 생성된다.")
    @Test
    void createLadderTest() {
        Ladder ladder = Ladder.from(5, 5, new RandomConnectStrategy());
        System.out.println(ladder);
    }

    @DisplayName("사다리의 높이가 1보다 작으면 예외가 발생한다..")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void createLadderTestFail(int height) {
        Assertions.assertThatThrownBy(() -> Ladder.from(height, 5, new RandomConnectStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
