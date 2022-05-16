package nextstep.ladder.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Nested
    class of_정적팩토리_메서드는 {

        @Nested
        class true가_주어질경우 {

            @Test
            void true를_리턴한다() {
                Point point = Point.of(() -> true);
                assertThat(point).isEqualTo(new Point(true));
            }

        }

        @Nested
        class false가_주어질경우 {

            @Test
            void false를_리턴한다() {
                Point point = Point.of(() -> false);
                assertThat(point).isEqualTo(new Point(false));
            }

        }
    }

    @Nested
    class isTrue_메서드는 {

        @Nested
        class ture가_주어질경우 {

            @Test
            void true를_리턴한다() {
                Point point = new Point(true);
                assertThat(point.isTrue()).isTrue();
            }

        }

        @Nested
        class false가_주어질경우 {

            @Test
            void false를_리턴한다() {
                Point point = new Point(false);
                assertThat(point.isTrue()).isFalse();
            }

        }
    }

    @Nested
    class isFalse_메서드는 {

        @Nested
        class ture가_주어질경우 {

            @Test
            void false를_리턴한다() {
                Point point = new Point(true);
                assertThat(point.isFalse()).isFalse();
            }

        }

        @Nested
        class false가_주어질경우 {

            @Test
            void true를_리턴한다() {
                Point point = new Point(false);
                assertThat(point.isFalse()).isTrue();
            }

        }
    }

    @Nested
    class getEdgeOrEmpty_메서드는 {

        @Nested
        class true일_경우 {

            @Test
            void 다리_문자열을_리턴한다() {
                Point point = new Point(true);
                assertThat(point.getEdgeOrEmpty()).isEqualTo("|-----");
            }
        }

        @Nested
        class false일_경우 {

            @Test
            void 빈_막대기를_리턴한다() {
                Point point = new Point(false);
                assertThat(point.getEdgeOrEmpty()).isEqualTo("|     ");
            }
        }
    }
}
