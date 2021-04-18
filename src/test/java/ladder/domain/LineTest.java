package ladder.domain;

import ladder.exception.PointListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("Line 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        List<Point> points = new ArrayList<>();

        // when
        Line line = Line.of(points);

        // then
        assertThat(line).isNotNull();
    }

    @DisplayName("Line 인스턴스에 null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_NULL() {
        // given
        List<Point> points = null;

        // when and then
        assertThatThrownBy(() -> Line.of(points))
                .isInstanceOf(PointListNullPointerException.class)
                .hasMessage("List<Point>가 null 입니다.");
    }


}