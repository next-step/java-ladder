package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderLevelTest {

    @DisplayName("ladder level 은 bar 로 시작하지 않으면 exception 을 던진다")
    @Test
    void shouldBarAtFirst(){
        assertThatThrownBy(() -> new LadderLevel(Arrays.asList(
                LadderItem.Step,
                LadderItem.Step,
                LadderItem.Bar
        ))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("ladder level 은 bar 로 끝나지 않으면 exception 을 던진다")
    @Test
    void shouldBarAtLast(){
        assertThatThrownBy(() -> new LadderLevel(Arrays.asList(
                LadderItem.Bar,
                LadderItem.Step,
                LadderItem.Step
        ))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("ladder level 에서 step 은 연속해서 만들수 없다")
    @Test
    void shouldNotContinuesStep(){
        assertThatThrownBy(() -> new LadderLevel(Arrays.asList(
                LadderItem.Bar,
                LadderItem.Step,
                LadderItem.Bar,
                LadderItem.Step,
                LadderItem.Bar
        ))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Bar 에서만 이동을 시작할 수 있다")
    @Test
    void illegalStartPos(){
        LadderLevel ladderLevel = new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Step, LadderItem.Bar));

        assertThatThrownBy(() -> ladderLevel.move(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("오른쪽에 step 이 있으면 오른쪽으로 이동한다")
    @Test
    void moveRight(){
        LadderLevel ladderLevel = new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Step, LadderItem.Bar));
        assertThat(ladderLevel.move(0)).isEqualTo(2);
    }

    @DisplayName("왼쪽에 step 이 있으면 왼쪽으로 이동한다")
    @Test
    void moveLeft(){
        LadderLevel ladderLevel = new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Step, LadderItem.Bar));
        assertThat(ladderLevel.move(2)).isEqualTo(0);
    }

    @DisplayName("양쪽 모두 step 이 없으면 이동하지 않고 현재위치에서 내려간다")
    @Test
    void notMove1(){
        LadderLevel ladderLevel = new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar));
        assertThat(ladderLevel.move(2)).isEqualTo(2);
    }

    @DisplayName("끝에서 시작하고 왼쪽에 step이 없으면 이동하지 않고 현재위치에서 내려간다")
    @Test
    void notMove2(){
        LadderLevel ladderLevel = new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar));
        assertThat(ladderLevel.move(4)).isEqualTo(4);
    }

    @DisplayName("맨앞에서 시작하고 왼쪽에 step이 없으면 이동하지 않고 현재위치에서 내려간다")
    @Test
    void notMove3(){
        LadderLevel ladderLevel = new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar));
        assertThat(ladderLevel.move(0)).isEqualTo(0);
    }

}
