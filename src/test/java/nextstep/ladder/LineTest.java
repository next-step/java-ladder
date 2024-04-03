package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    @DisplayName("라인이 겹칠 때 생성 불가 테스트")
    void lineOverLabTest() {
        assertThatThrownBy(() -> new Line(List.of(true, true, false)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("라인 생성 테스트")
    void lineConstructTest() {
        Line line = new Line(List.of(false,true,false));
        assertThat(line.getPoints().get(1)).isEqualTo(true);
    }

}
