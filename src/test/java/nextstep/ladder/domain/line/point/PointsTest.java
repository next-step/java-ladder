package nextstep.ladder.domain.line.point;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTest {
    public static Points create(List<Boolean> booleanList) {
        return Points.of(booleanList);
    }

    @Nested
    class getPoint_메서드는 {

        @Test
        void 라인_문자열을_리턴한다() {
            Points points = create(List.of(true, false, false, true));

            String point = points.getPoint();

            assertThat(point).isEqualTo("|-----|     |     |-----");
        }

    }

    @Nested
    class sameSize_메서드는 {

        @Nested
        class 같은_사이즈가_주어지면 {

            @Test
            void true를_리턴한다() {
                Points points = create(List.of(true, false, false, true));

                assertThat(points.sameSize(4)).isTrue();
            }

        }

        @Nested
        class 다른_사이즈가_주어지면 {

            @Test
            void false를_리턴한다() {
                Points points = create(List.of(true, false, false, true));

                assertThat(points.sameSize(3)).isFalse();
            }

        }
    }

    @Nested
    class firstMatch_메서드는 {

        @Nested
        class 첫번째_요소가_true일경우 {

            @Test
            void true를_리턴한다() {
                Points points = create(List.of(true));
                
                assertThat(points.firstMatch()).isTrue();
            }

        }
        
        @Nested
        class 첫번째_요소가_false일경우 {
            
            @Test
            void false를_리턴한다() {
                Points points = create(List.of(false));

                assertThat(points.firstMatch()).isFalse();
            }
            
        }
    }

    @Nested
    class lastMatch_메서드는 {

        @Nested
        class 첫번째_요소가_true일경우 {

            @Test
            void true를_리턴한다() {
                Points points = create(List.of(true));

                assertThat(points.lastMatch()).isTrue();
            }

        }

        @Nested
        class 첫번째_요소가_false일경우 {

            @Test
            void false를_리턴한다() {
                Points points = create(List.of(false));

                assertThat(points.lastMatch()).isFalse();
            }

        }
    }

    @Nested
    class leftMatch_메서드는 {

        @Nested
        class 왼쪽_요소가_true일경우 {

            @Test
            void true를_리턴한다() {
                Points points = create(List.of(true, false));

                assertThat(points.leftMatch(1)).isTrue();
            }

        }

        @Nested
        class 왼쪽_요소가_false일경우 {

            @Test
            void false를_리턴한다() {
                Points points = create(List.of(false, false));

                assertThat(points.leftMatch(1)).isFalse();
            }

        }
    }

    @Nested
    class rightMatch_메서드는 {

        @Nested
        class 오른쪽_요소가_true일경우 {

            @Test
            void true를_리턴한다() {
                Points points = create(List.of(true, false));

                assertThat(points.rightMatch(0)).isTrue();
            }

        }

        @Nested
        class 오른쪽_요소가_false일경우 {

            @Test
            void false를_리턴한다() {
                Points points = create(List.of(false, false));

                assertThat(points.rightMatch(0)).isFalse();
            }

        }
    }

}
