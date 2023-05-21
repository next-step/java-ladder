package nextstep.ladder;

import nextstep.ladder.drawPolicy.AllDraw;
import nextstep.ladder.drawPolicy.DrawablePolicy;
import nextstep.ladder.drawPolicy.NoDraw;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void createFirstInstanceTest() {
        var actualPoint = Point.createInstance(new AllDraw());

        assertThat(actualPoint.isLeftConnected()).isFalse();
        assertThat(actualPoint.isRightConnected()).isTrue();
    }

    @Test
    void createInstanceTest_이전의지점이그려져있을때() {
        var beforePoint = Point.createInstance(new AllDraw());
        var actualPoint = Point.createInstance(beforePoint, new AllDraw());

        assertThat(actualPoint.isLeftConnected()).isTrue();
        assertThat(actualPoint.isRightConnected()).isFalse();
    }

    @Test
    void createInstanceTest_이전의지점이그려져있지않을때() {
        var beforePoint = Point.createInstance(new NoDraw());
        var actualPoint = Point.createInstance(beforePoint, new AllDraw());

        assertThat(actualPoint.isLeftConnected()).isFalse();
        assertThat(actualPoint.isRightConnected()).isTrue();
    }

    @Test
    void lastInstanceTest_이전의지점이그려져있을때() {
        var beforePoint = Point.createInstance(new AllDraw());
        var actualPoint = Point.lastInstance(beforePoint);

        assertThat(actualPoint.isLeftConnected()).isTrue();
        assertThat(actualPoint.isRightConnected()).isFalse();
    }

    @Test
    void lastInstanceTest_이전의지점이그려져있지않을때() {
        var beforePoint = Point.createInstance(new NoDraw());
        var actualPoint = Point.lastInstance(beforePoint);

        assertThat(actualPoint.isLeftConnected()).isFalse();
        assertThat(actualPoint.isRightConnected()).isFalse();
    }

    @ParameterizedTest
    @MethodSource("nextTestArguments")
    void nextTest(DrawablePolicy drawablePolicy, boolean expectLeftConnected, boolean expectRightConnected, Point currentPoint) {
        var nextPoint = currentPoint.next(drawablePolicy);

        assertThat(expectLeftConnected).isEqualTo(nextPoint.isLeftConnected());
        assertThat(expectRightConnected).isEqualTo(nextPoint.isRightConnected());
    }

    public static Stream<Arguments> nextTestArguments() {
        return Stream.of(
                Arguments.of(new NoDraw(), false, false, Point.createInstance(new NoDraw())),
                Arguments.of(new NoDraw(), true, false, Point.createInstance(new AllDraw())),
                Arguments.of(new AllDraw(), false, true, Point.createInstance(new NoDraw())),
                Arguments.of(new AllDraw(), true, false, Point.createInstance(new AllDraw()))
        );
    }
}