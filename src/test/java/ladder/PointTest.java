package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("Line는 true, false 값을 가질 수 있다.")
    void createPoint(){
        assertThat(new Line(true)).isInstanceOf(Line.class);
    }
}
