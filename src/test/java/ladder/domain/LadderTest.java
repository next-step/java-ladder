package ladder.domain;

import static ladder.domain.Link.LEFT_LINK;
import static ladder.domain.Link.NO_LINK;
import static ladder.domain.Link.RIGHT_LINK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리가 정상적으로 생성된다")
    void success() {
        Line line = LineFactory.generate(5);
        assertThatNoException()
            .isThrownBy(() -> Ladder.from(List.of(line)));
    }

    @Test
    @DisplayName("빈 Line이라면 사다리가 정상적으로 생성되지 않는다")
    void name() {
        assertThatThrownBy(() -> Ladder.from(Collections.emptyList()))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("인덱스 별 사다리 결과를 반환한다")
    void result() {
        Ladder ladder = makeLadder();
        LadderResult result = ladder.result();

        assertThat(result.resultIndexOf(0)).isEqualTo(2);
        assertThat(result.resultIndexOf(1)).isEqualTo(0);
        assertThat(result.resultIndexOf(2)).isEqualTo(3);
        assertThat(result.resultIndexOf(3)).isEqualTo(1);
    }

    private static Ladder makeLadder() {
        /*
            |-----|     |-----|
            |     |-----|     |
         */
        return Ladder.from(
            List.of(
                Line.from(List.of(RIGHT_LINK, LEFT_LINK, RIGHT_LINK, LEFT_LINK)),
                Line.from(List.of(NO_LINK, RIGHT_LINK, LEFT_LINK, NO_LINK))
            )
        );
    }
}
