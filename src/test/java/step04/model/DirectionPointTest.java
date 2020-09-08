package step04.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionPointTest {

    @DisplayName("길이 왼쪽에 있는지 테스트")
    @ParameterizedTest
    @MethodSource("provideDirectionPointAndResult")
    void isLeft(DirectionPoint directionPoint, boolean expected) {
        // when & then
        assertThat(directionPoint.isLeft()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideDirectionPointAndResult() {
        return Stream.of(
                Arguments.of(DirectionPoint.of(Point.ROW, Point.BLANK), true),
                Arguments.of(DirectionPoint.of(Point.BLANK, Point.ROW), false)
        );
    }

    @DisplayName("길이 오른쪽에 있는지 테스트")
    @ParameterizedTest
    @MethodSource("provideDirectionPointAndResult2")
    void isRight(DirectionPoint directionPoint, boolean expected) {
        // when & then
        assertThat(directionPoint.isRight()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideDirectionPointAndResult2() {
        return Stream.of(
                Arguments.of(DirectionPoint.of(Point.ROW, Point.BLANK), false),
                Arguments.of(DirectionPoint.of(Point.BLANK, Point.ROW), true)
        );
    }

    @DisplayName("출력 테스트")
    @Test
    void printString() {
        // given
        DirectionPoint directionPoint = DirectionPoint.of(Point.BLANK, Point.ROW);

        // when
        System.out.println(directionPoint.toString());
    }
}
