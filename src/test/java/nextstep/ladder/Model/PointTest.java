package nextstep.ladder.Model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    private static final int RIGHT_EXPECT_LOCATION =2;
    private static final int LEFT_EXPECT_LOCATION =0;
    private static final int PASS_EXPECT_LOCATION =1;
    private static final int START_LOCATION =1;

    @Test
    void right() {
        Bridge right = Bridge.first(() -> true);
        Point point = new Point(START_LOCATION, right);
        assertThat(point.move()).isEqualTo(RIGHT_EXPECT_LOCATION);
    }

    @Test
    void left() {
        Bridge left = Bridge.first(() -> true).next(() -> false);
        Point point = new Point(START_LOCATION, left);
        assertThat(point.move()).isEqualTo(LEFT_EXPECT_LOCATION);
    }

    @Test
    void pass() {
        Bridge pass = Bridge.first(() -> false);
        Point point = new Point(START_LOCATION, pass);
        assertThat(point.move()).isEqualTo(PASS_EXPECT_LOCATION);
    }

}