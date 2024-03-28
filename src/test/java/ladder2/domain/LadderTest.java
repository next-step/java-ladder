package ladder2.domain;

import static ladder2.domain.Link.LEFT_LINK;
import static ladder2.domain.Link.NO_LINK;
import static ladder2.domain.Link.RIGHT_LINK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder2.domain.factory.LadderRowFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    private static final int ANY_POSITIVE = 5;

    @Test
    @DisplayName("성공적으로 인스턴스화된다")
    void new_success() {
        List<LadderRow> rows = List.of(LadderRowFactory.generate(ANY_POSITIVE));
        assertThatNoException()
            .isThrownBy(() -> new Ladder(rows));
    }

    @Test
    @DisplayName("사다리 행이 1개도 없을 경우 예외가 발생한다")
    void new_empty_exception() {
        assertThatThrownBy(() -> new Ladder(List.of()))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("모든 사다리 행의 열 크기가 같지 않을 경우 예외가 발생한다")
    void new_not_same_size_columns_exception() {
        List<LadderRow> rows = List.of(
            LadderRowFactory.generate(3),
            LadderRowFactory.generate(4)
        );
        assertThatThrownBy(() -> new Ladder(rows))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 결과를 반환한다")
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
        return new Ladder(
            List.of(
                LadderRow.of(RIGHT_LINK, LEFT_LINK, RIGHT_LINK, LEFT_LINK),
                LadderRow.of(NO_LINK, RIGHT_LINK, LEFT_LINK, NO_LINK)
            )
        );
    }
}
