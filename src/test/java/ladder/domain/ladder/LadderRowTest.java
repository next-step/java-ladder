package ladder.domain.ladder;

import ladder.strategy.LineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowTest {

    private LineStrategy lineStrategy = () -> true;
    private LadderRow ladderRow;

    @BeforeEach
    void setUp() {
        ladderRow = new LadderRow(Arrays.asList(false, true, false));
    }


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
        assertThat(ladderRow.hasLine(0)).isFalse();
        assertThat(ladderRow.hasLine(1)).isTrue();
        assertThat(ladderRow.hasLine(2)).isFalse();
    }

    @Test
    @DisplayName("왼쪽의 끝인지 판단하는 함수의 값을 확인한다.")
    void isLeftEnd_IfEnd_True() {
        assertThat(ladderRow.isLeftEnd(0)).isTrue();
    }

    @Test
    @DisplayName("오른쪽의 끝인지 판단하는 함수의 값을 확인한다.")
    void isRightEnd_IfEnd_True() {
        assertThat(ladderRow.isRightEnd(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("끝이 아닌지 판단하는 함수의 값을 확인한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void isNotEnd_IfNotEnd_Ture(int input) {
        assertThat(ladderRow.isNotEnd(input)).isTrue();
    }

}
