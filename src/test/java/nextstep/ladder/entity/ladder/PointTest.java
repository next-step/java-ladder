package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private static final int POINT_COUNT = 4;

    private Point startPoint = new Point();

    @BeforeEach
    void init() {

        Point current = startPoint;
        Point next = null;
        for (int count = 1; count <= POINT_COUNT; count++) {
            next = new Point();
            current.next(next);
            current = next;
        }

    }

    @Test
    void test_isLinked_true() {
        // Given
        Point pointA = new Point();
        Point pointB = new Point();
        pointA.next(pointB);

        // When
        pointA.linkWithNext();

        // Then
        assertTrue(pointA.isLinked());
    }

    @Test
    void test_isLinked_false() {
        // Given
        Point pointA = new Point();
        Point pointB = new Point();
        pointA.next(pointB);

        // When
        // pointA.linkWithNext();

        // Then
        assertFalse(pointA.isLinked());
    }

    @Test
    void test_hasNext_true() {
        // Given
        Point pointA = new Point();
        Point pointB = new Point();

        // When
        pointA.next(pointB);

        // Then
        assertTrue(pointA.hasNext());
    }

    @Test
    void test_hasNext_false() {
        // Given
        Point point = new Point();

        // When & Then
        assertFalse(point.hasNext());
    }

    @Test
    void test_hasBackwardLink_true() {
        // Given
        Point pointA = new Point();
        Point pointB = new Point();
        pointA.next(pointB);

        // When
        pointA.linkWithNext();

        // Then
        assertTrue(pointB.hasBackwardLink());
    }

    @Test
    void test_hasBackwardLink_false() {
        // Given
        Point pointA = new Point();
        Point pointB = new Point();
        pointA.next(pointB);

        // When
        //pointA.linkWithNext();

        // Then
        assertFalse(pointB.hasBackwardLink());
    }


}