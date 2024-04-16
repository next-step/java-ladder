package ladder.fixture;

import ladder.domain.*;

import java.util.List;
import java.util.Map;

public class Fixture {
    public static Lines makeValidLines(){
        Points points1 = new Points(List.of(
                new Point(false),
                new Point(true))
        );

        Points points2 = new Points(
                List.of(new Point(true),
                        new Point(false))
        );

        return new Lines(List.of(new Line(points1), new Line(points2)));
    }

    public static Lines makeInvalidLines(){
        Points points1 = new Points(List.of(
                new Point(true),
                new Point(true))
        );

        Points points2 = new Points(
                List.of(new Point(false),
                        new Point(false))
        );

        return new Lines(List.of(new Line(points1), new Line(points2)));
    }

    public static Players make3Players(){
        return new Players(List.of(
                new Player("A"),
                new Player("B"),
                new Player("C"))
        );
    }

    public static Results make3Results(){
        return new Results(List.of(
                new Result("1-C"),
                new Result("2-A"),
                new Result("3-B"))
        );
    }

    public static Map<Player, Result> makePlayerResult(){
        return Map.of(
                new Player("A"), new Result("2-A"),
                new Player("B"), new Result("3-B"),
                new Player("C"), new Result("1-C")
        );
    }
}
