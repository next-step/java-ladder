package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("라인 사이즈 테스트")
    public void lineSizeStest() {
        Line line = new Line(3);
        assertThat(line.getPoints().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("2명 이하 테스트")
    public void validationline() {
        assertThatThrownBy(() -> {
           Line line = new Line(1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라인에 둘다true인 경우 있는지 체크")
    public void lineValidationCheck() {
        Line line = new Line(7);
        for(int i = 0; i < line.getPoints().size(); i++) {
            assertThat(line.getPoints().get(i).isNextPoint() && line.getPoints().get(i).isPrevPoint()).isFalse();
        }
    }
}
