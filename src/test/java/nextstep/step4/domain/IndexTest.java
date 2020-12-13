package nextstep.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexTest {

    @Test
    @DisplayName("오른쪽으로 이동 시 인덱스")
    void right() {
        Point right = Point.setFirst((boolean previous) -> true);
        Index index = Index.of(1, right);
        Assertions.assertThat(index.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("왼쪽으로 이동 시 인덱스")
    void left() {
        Point left= Point.setFirst((boolean previous) ->true).setNext((boolean previous) -> false);
        Index index = Index.of(1, left);
        Assertions.assertThat(index.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("직진일 때 인덱스")
    void forward() {
        Point forward= Point.setFirst((boolean previous) -> false);
        Index index = Index.of(1, forward);
        Assertions.assertThat(index.move()).isEqualTo(1);
    }

}