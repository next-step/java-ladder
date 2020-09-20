package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("firstPoint 는 Location 초기 값과 firstDirection 으로 구성")
    void createFirstPoint(boolean firstPointRightDirection) {
        Point firstPoint = Point.first(() -> firstPointRightDirection);

        assertThat(firstPoint).isEqualTo(Point.of(Location.init(), Direction.first(firstPointRightDirection)));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("nextPoint 는 Location 의 toRight 값과 Direction 의 next 값 ")
    void createNextPoint(boolean nextPointRightDirection) {
        Location standardLocation = Location.from(3);
        Direction standardDirection = Direction.of(false, false);
        Point standardPoint = Point.of(standardLocation, standardDirection);
        DirectionStrategy standardStrategy = () -> nextPointRightDirection;

        assertThat(standardPoint.next(standardStrategy))
                .isEqualTo(Point.of(standardLocation.toRight(), standardDirection.next(standardStrategy)));
    }

    @Test
    @DisplayName("lastPoint 는 Location toRight 값 과  Direction 의 last 값 ")
    void createLastPoint() {
        Location standardLocation = Location.from(3);
        Direction standardDirection = Direction.of(false, false);
        Point standardPoint = Point.of(standardLocation, standardDirection);

        assertThat(standardPoint.last())
                .isEqualTo(Point.of(standardLocation.toRight(), standardDirection.last()));
    }

    @ParameterizedTest
    @CsvSource(value = {"5,false,true,6", "3,true,false,2", "0,false,true,1", "3,false,false,3"})
    @DisplayName("Point move case")
    void move(int location, boolean directionLeft, boolean directionRight, int expected) {
        Location standardLocation = Location.from(location);
        Direction standardDirection = Direction.of(directionLeft, directionRight);
        Point standardPoint = Point.of(standardLocation, standardDirection);

        assertThat(standardPoint.move()).isEqualTo(Location.from(expected));
    }
}
