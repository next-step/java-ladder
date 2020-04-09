package nextstep.ladder.domain;

import nextstep.ladder.domain.step.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
    @DisplayName("사다리 정상 생성")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void createLadder(int heightOfLadder) {
        assertThatCode(() -> Ladder.of(Arrays.asList(new Person("dong"), new Person("chul")), heightOfLadder))
                .doesNotThrowAnyException();
    }

    @DisplayName("라인이 1개 이하 일 경우 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void createFailByLineCount(int heightOfLadder) {
        assertThatIllegalArgumentException().isThrownBy(() ->  Ladder.of(Arrays.asList(new Person("dong")), heightOfLadder));
    }

    @DisplayName("높이가 1보다 작을 경우 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-5, -3, 0, 1})
    void createFailByHeight(int heightOfLadder) {
        assertThatIllegalArgumentException().isThrownBy(() ->  Ladder.of(Arrays.asList(new Person("dong")), heightOfLadder));
    }

    @DisplayName("사다리 타기 게임 실행")
    @ParameterizedTest
    @ValueSource(ints = 5)
    void ladderGame(int heightOfLadder) {
        Ladder ladder = Ladder.of(Arrays.asList(new Person("dong"), new Person("chul")), heightOfLadder);
        Step result = ladder.findResult("dong");

        assertThat(result.getLinePosition()).isBetween(0, 1);
    }
}
