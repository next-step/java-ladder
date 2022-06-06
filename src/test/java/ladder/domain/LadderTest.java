package ladder.domain;

import ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @DisplayName("사다리 정상 생성 테스트")
    @Test
    void from() {
        Ladder ladder = LadderFactory.create(5, 4, new RandomLineStrategy());
        System.out.println(ladder);
        assertThat(ladder).isNotNull();
    }

    @DisplayName("사다리를 생성하기 위한 인자값이 빈값 또는 null 인 경우 예외 발생 테스트")
    @Test
    void emptyException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.from(new ArrayList<>()))
                .withMessageContaining("존재하지 않습니다.")
        ;
    }

    @DisplayName("사다리 이동 테스트")
    @Test
    void play() {
        Ladder ladder = LadderFactory.create(5, 4, new RandomLineStrategy());
        LadderResult result = ladder.play();
        System.out.println(result);
        assertThat(result).isNotNull();
    }

    @DisplayName("사다리 이동 결과 확인 테스트")
    @Test
    void play_result() {
        Ladder ladder = Ladder.from(Line.from(false, true, false, false), Line.from(false, true, false, true));
        LadderResult result = ladder.play();
        System.out.println(result);
        assertThat(result.goalOf(Position.from(0))).isEqualTo(Position.from(0));
        assertThat(result.goalOf(Position.from(1))).isEqualTo(Position.from(1));
        assertThat(result.goalOf(Position.from(2))).isEqualTo(Position.from(3));
        assertThat(result.goalOf(Position.from(3))).isEqualTo(Position.from(2));
    }
}