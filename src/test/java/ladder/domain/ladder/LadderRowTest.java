package ladder.domain.ladder;

import ladder.strategy.LineStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowTest {

    private LineStrategy lineStrategy = () -> true;

    @Test
    @DisplayName("주어진 너비(width) 만큼의 line을 생성한다.")
    public void create_Width_Line() {
        LadderRow ladderRow = new LadderRow(5);
        assertThat(ladderRow.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("연달아서 라인(true) 을 생성하지 않는다.")
    public void create_DuplicateLine_Not() {
        LadderRow ladderRow = new LadderRow(3, lineStrategy);
        assertThat(ladderRow.getLines()).containsExactly(true, false, true);
    }

    @Test
    @DisplayName("해당하는 곳의 라인이 있는지 판단하는 함수의 값을 확인한다.")
    void hasLine_IfThereTrue_True() {
        LadderRow ladderRow = new LadderRow(Arrays.asList(false, true, false));
        Assertions.assertThat(ladderRow.hasLine(0)).isFalse();
        Assertions.assertThat(ladderRow.hasLine(1)).isTrue();
        Assertions.assertThat(ladderRow.hasLine(2)).isFalse();
    }


}
