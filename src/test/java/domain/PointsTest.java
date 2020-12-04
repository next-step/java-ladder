package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest extends Points{
    private Points points;

    public PointsTest() {
        super();
    }

    @BeforeEach
    void setUp() {
        Point p1 = Point.of(0, Direction.RIGHT);
        Point p2 = Point.of(1, Direction.LEFT);
        Point p3 = Point.of(2, Direction.DOWN);

        List<Point> points = new ArrayList<>();
        points.add(p1);
        points.add(p2);
        points.add(p3);

        this.points = new Points(points);
    }

/*
    @Test
    void ofTest() {
        Points points = Points.of(Length.of(3));
        assertThat(points.stream().count()).isEqualTo(3);
    }*/

    @Test
    void movePointAt() {
        assertThat(points.movePointAt(0)).isEqualTo(1);
        assertThat(points.movePointAt(1)).isEqualTo(0);
        assertThat(points.movePointAt(2)).isEqualTo(2);


    }

}
