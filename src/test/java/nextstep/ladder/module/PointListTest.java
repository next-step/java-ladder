package nextstep.ladder.module;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointListTest {

    @Test
    @DisplayName("PointList 생성 시 지정된 크기만큼 Point 객체가 생성되어야 한다")
    void createPointList() {
        // given
        int size = 5;

        // when
        PointList pointList = new PointList(size);

        // then
        assertThat(pointList.points()).hasSize(size);
        for (int i = 0; i < size; i++) {
            assertThat(pointList.get(i)).isEqualTo(new Point(i));
        }
    }
} 