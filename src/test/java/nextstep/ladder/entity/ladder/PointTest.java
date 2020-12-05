package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private static final int POINT_COUNT = 4;

    private Point startPoint = Point.start();

    @BeforeEach
    void init() {

        Point current = startPoint;
        Point next = null;
        for (int count = 2; count <= POINT_COUNT; count++) {
            next = Point.of(count);
            current.next(next);
            current = next;
        }

    }

    @Test
    void test_isLinked_true() {
        // Given
        Point pointA = Point.of(1);
        Point pointB = Point.of(2);
        pointA.next(pointB);

        // When
        pointA.linkWithNext();

        // Then
        assertTrue(pointA.isLinked());
    }

    @Test
    void test_isLinked_false() {
        // Given
        Point pointA = Point.of(1);
        Point pointB = Point.of(2);
        pointA.next(pointB);

        // When
        // pointA.linkWithNext();

        // Then
        assertFalse(pointA.isLinked());
    }

    @Test
    void test_hasNext_true() {
        // Given
        Point pointA = Point.of(1);
        Point pointB = Point.of(2);

        // When
        pointA.next(pointB);

        // Then
        assertTrue(pointA.hasNext());
    }

    @Test
    void test_hasNext_false() {
        // Given
        Point point = Point.start();

        // When & Then
        assertFalse(point.hasNext());
    }

    @Test
    void test_hasBackwardLink_true() {
        // Given
        Point pointA = Point.of(1);
        Point pointB = Point.of(2);
        pointA.next(pointB);

        // When
        pointA.linkWithNext();

        // Then
        assertTrue(pointB.hasBackwardLink());
    }

    @Test
    void test_hasBackwardLink_false() {
        // Given
        Point pointA = Point.of(1);
        Point pointB = Point.of(2);
        pointA.next(pointB);

        // When
        //pointA.linkWithNext();

        // Then
        assertFalse(pointB.hasBackwardLink());
    }


}