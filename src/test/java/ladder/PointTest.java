package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.PointElement.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    void nextLinePosition() {
        // given
        int position = 1;

        // when
        Point leftPoint = new Point(position, LEFT);
        Point passPoint = new Point(position, PASS);
        Point rightPoint = new Point(position, RIGHT);

        // then
        assertThat(leftPoint.nextLinePosition()).isSameAs(Position.of(0));
        assertThat(passPoint.nextLinePosition()).isSameAs(Position.of(1));
        assertThat(rightPoint.nextLinePosition()).isSameAs(Position.of(2));
    }

    @Test
    void nextPoint() {
        // given
        int position = 1;

        // when
        Point leftPoint = new Point(position, LEFT);
        Point passPoint = new Point(position, PASS);
        Point rightPoint = new Point(position, RIGHT);

        // then
        assertThat(leftPoint.nextPoint(false)).isEqualTo(new Point(2, PASS));
        assertThat(leftPoint.nextPoint(true)).isEqualTo(new Point(2, RIGHT));
        assertThat(passPoint.nextPoint(false)).isEqualTo(new Point(2, PASS));
        assertThat(passPoint.nextPoint(true)).isEqualTo(new Point(2, RIGHT));
        assertThat(rightPoint.nextPoint(false)).isEqualTo(new Point(2, LEFT));
        assertThatThrownBy(() -> rightPoint.nextPoint(true)).isInstanceOf(IllegalArgumentException.class);
    }
}
