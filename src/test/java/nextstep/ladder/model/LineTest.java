package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    @DisplayName("잘못된 위치를 요청할 때 테스트")
    @Test
    public void requestWrongPosition() {
        //given
        int height = 3;
        int index = 1;
        Line line = new Line(height, index);

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> line.getPoint(5));
    }
}
