package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @DisplayName("참가자는 최소 2명 이상이어야 한다.")
    @Test
    void atLeast2Player() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Line(1);
        });
    }


    @DisplayName("Line이 가진 Point의 수는 참가자 수 - 1이다.")
    @Test
    void linePointCOunt() {
        assertThat(new Line(3).getPoints().size()).isEqualTo(2);
    }

}
