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
                Points points = new Points(this.booleans);

                String point = points.getPoint();

                assertThat(point).isEqualTo("|-----|     |     |-----");
            }
        }
    }
}
