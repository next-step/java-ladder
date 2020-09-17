package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("생성자 정상 작동")
    void create(boolean connection) {
        assertNotNull(Point.of(connection));
    }

    @Test
    @DisplayName("객체 재사용 확인")
    void reusable() {
        assertTrue(Point.of(true) == Point.of(true));
        assertTrue(Point.of(false) == Point.of(false));
    }

    @ParameterizedTest
    @MethodSource("providePointsAndResult")
    @DisplayName("이웃 Point와 연결 여부 확인")
    void checkConnected(Point before, Point after, boolean expected) {
        assertEquals(before.checkConnected(after), expected);
    }

    private static Stream<Arguments> providePointsAndResult() {
        return Stream.of(
                Arguments.of(Point.of(true), Point.of(true), true),
                Arguments.of(Point.of(true), Point.of(false), false),
                Arguments.of(Point.of(false), Point.of(true), false),
                Arguments.of(Point.of(false), Point.of(false), false)
        );
    }
}
