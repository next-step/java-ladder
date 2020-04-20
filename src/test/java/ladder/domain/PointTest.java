package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("시작점이 만들어지고 이동")
    @Test
    void moveByFirstCreation() {
        Point first = Point.first(TRUE);
        assertThat(first.move()).isEqualTo(new Position(1));

        first = Point.first(FALSE);
        assertThat(first.move()).isEqualTo(new Position(0));
    }

    @DisplayName("연결점이 만들어지고 이동")
    @Test
    void moveByNextCreation() {
        Point first = Point.first(TRUE);
        assertThat(first.next(FALSE).move()).isEqualTo(new Position(0));

        first = Point.first(FALSE);
        assertThat(first.next(TRUE).move()).isEqualTo(new Position(2));
    }

    @DisplayName("마지막점이 만들어지고 이동")
    @Test
    void moveByLastCreation() {
        Point first = Point.first(TRUE);
        assertThat(first.last().move()).isEqualTo(new Position(0));

        first = Point.first(FALSE);
        assertThat(first.last().move()).isEqualTo(new Position(1));
    }
}
