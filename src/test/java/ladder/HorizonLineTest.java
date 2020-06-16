package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HorizonLineTest {

    @DisplayName("사다리 시작 포인트 수의 -1 만큼 짧은 가로줄을 만들 수 있다")
    @Test
    public void createTest() {
        HorizonLine horizonLine = new HorizonLine(5, () -> true);

        assertThat(horizonLine.getShortLineCount()).isEqualTo(4);
    }

    @DisplayName("연이어 짧은 라인(ShortLine)은 겹칠 수 없다.")
    @Test
    public void validateContinuousShortLine() {
        HorizonLine horizonLine = new HorizonLine(5, () -> true);

        assertThat(horizonLine.isEnabledShortLineOfRight(0)).isEqualTo(true);
        assertThat(horizonLine.isEnabledShortLineOfRight(1)).isEqualTo(false);
        assertThat(horizonLine.isEnabledShortLineOfRight(2)).isEqualTo(true);
        assertThat(horizonLine.isEnabledShortLineOfRight(3)).isEqualTo(false);
        assertThat(horizonLine.isEnabledShortLineOfRight(4)).isEqualTo(false);
    }

    @DisplayName("입력된 포지션의 왼쪽의 짧은 라인의 유무를 알수 있다.")
    @Test
    public void isEnabledShortLineOfLeftTest() {
        HorizonLine horizonLine = new HorizonLine(2, () -> true);
        assertThat(horizonLine.isEnabledShortLineOfLeft(1)).isEqualTo(true);
    }

    @DisplayName("입력된 포지션의 오른쪽의 짧은 라인의 유무를 알수 있다.")
    @Test
    public void isEnabledShortLineOfRightTest() {
        HorizonLine horizonLine = new HorizonLine(3, () -> true);
        assertThat(horizonLine.isEnabledShortLineOfRight(1)).isEqualTo(false);
    }

    @DisplayName("좌우 짧은 라인의 유무를 알기 위해 입력되는 포지션이 총 포지션을 벗어날 경우 IllegalArgument 오류 발생한다.")
    @Test
    public void validatePositionRangeTest() {
        HorizonLine horizonLine = new HorizonLine(5, () -> true);
        assertThatThrownBy(()-> {
            horizonLine.isEnabledShortLineOfRight(5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("최소 입력 할 수 있는 포지션의 수보다 작게 입력하면 IllegalArgument 오류가 발생한다.")
    @Test
    public void validateMinimumPositionTest() {
        assertThatThrownBy(()-> {
            HorizonLine horizonLine = new HorizonLine(1, () -> true);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
