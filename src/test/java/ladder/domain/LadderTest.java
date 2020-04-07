package ladder.domain;

import ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @DisplayName("시작 노드의 수와 게임 결과의 수가 일치해야 한다.")
    @Test
    public void constructor_success() throws Exception {
        //given
        Lines lines = new Lines(Arrays.asList(new Line(), new Line()));
        LadderPrize gameResult = new LadderPrize(Arrays.asList("5000", "꽝"));

        //then
        assertThatThrownBy(
                () -> new Ladder(lines, gameResult)
        ).isInstanceOf(LadderException.class);
    }

    @DisplayName("시작 노드의 수와 게임 결과의 수가 일치 하지 않으면 exception")
    @Test
    public void constructor_실패() throws Exception {
        //given
        Lines lines = new Lines(Arrays.asList(new Line()));
        LadderPrize gameResult = new LadderPrize(Arrays.asList("5000", "꽝"));

        //then
        assertThatThrownBy(
                () -> new Ladder(lines, gameResult)
        ).isInstanceOf(LadderException.class);
    }
}
