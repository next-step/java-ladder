package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {

    @Nested
    class getPoint_메서드는 {

        @Nested
        class boolean_리스트가_주어지면 {
            private List<Boolean> booleans;

            @BeforeEach
            void setUp() {
                this.booleans = Arrays.asList(true, false, false, true);
            }

            @Test
            void 라인_문자열을_리턴한다() {
                Points points = Points.of(this.booleans);

                String point = points.getPoint();

                assertThat(point).isEqualTo("|-----|     |     |-----");
            }
        }

        @Nested
        class booleanGenerator가_주어질때 {

            @Test
            void 문자열_검증() {
                Members members = new Members("pobi,jason,pang,nem");
                Points points = Points.of(members, () -> true);

                assertThat(points.getPoint()).isEqualTo("|-----|     |-----");

                points = Points.of(members, () -> false);
                assertThat(points.getPoint()).isEqualTo("|     |     |     ");
            }
        }
    }
}
