package my.project.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created : 2020-12-10 오전 11:49
 * Developer : Seo
 */
class PointTest {

    @DisplayName("포인터 이동 확인")
    @Test
    void move() {
        Point point = new Point(0, 0);
        point.move(1, 1);
        assertThat(point.getX()).isEqualTo(1);
        assertThat(point.getY()).isEqualTo(1);
    }
}