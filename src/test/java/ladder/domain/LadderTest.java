package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {
    @DisplayName("사다리 정상 생성 테스트")
    @Test
    void from() {
        List<Line> lines = LineFactory.createLines(5, 4, new RandomLineStrategy());
        Ladder ladder = Ladder.from(lines);
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
}