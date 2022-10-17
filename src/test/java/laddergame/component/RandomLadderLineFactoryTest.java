package laddergame.component;

import laddergame.domain.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RandomLadderLineFactoryTest {

    private final LadderLineFactory ladderLineFactory = new RandomLadderLineFactory();

    @DisplayName("세로 막대의 개수가 1개인 경우, 세로 막대에 연결된 것이 없어야 한다.")
    @Test
    void createLadderLine_givenOneColumn() {
        LadderLine actual = ladderLineFactory.createLadderLine(1);
        assertThat(actual).isEqualTo(new LadderLine(Collections.emptyList()));
    }

    @DisplayName("세로 막대의 개수가 2개인 경우, 세로 막대는 연결되거나 연결되지 않아야 한다.")
    @Test
    void createLadderLine_givenTwoColumns() {
        LadderLine actual = ladderLineFactory.createLadderLine(2);
        assertThat(actual).isIn(
                new LadderLine(List.of(true)),
                new LadderLine(List.of(false))
        );
    }

    @DisplayName("세로 막대의 개수가 1보다 작은 경우, 예외가 발생해야 한다.")
    @Test
    void createLadderLine_givenNumberOfColumnsUnderMinValueOfColumns() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderLineFactory.createLadderLine(0));
    }

}
