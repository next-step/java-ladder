package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        this.line = new Line(Arrays.asList(
                Point.of(0,Pointer.of(false,true)),
                Point.of(1,Pointer.of(true,false)),
                Point.of(2,Pointer.of(false,true)),
                Point.of(3,Pointer.of(true,false)),
                Point.of(4,Pointer.of(false,false))
        ));
    }

    @Test
    @DisplayName("동일한 Point 값의 객체를 생성 후 동일한 객체인지 비교")
    void line_points_isEqualTo() {
        Line expect = new Line(Arrays.asList(
                Point.of(0,Pointer.of(false,true)),
                Point.of(1,Pointer.of(true,false)),
                Point.of(2,Pointer.of(false,true)),
                Point.of(3,Pointer.of(true,false)),
                Point.of(4,Pointer.of(false,false))
        ));

        assertThat(line).isEqualTo(expect);
    }

    @Test
    @DisplayName("Line 객체 Point index 가 어느 Point 로 이동했는지 확인")
    void line_pointMovePosition_isEqualTo() {
        assertThat(line.movePoint(1)).isEqualTo(0);
    }
}
