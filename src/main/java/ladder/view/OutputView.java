package ladder.view;

import ladder.domain.Line;
import ladder.domain.RandomGenerateStrategy;

import java.util.List;

public class OutputView {

    public void printLadder(List<Line> lines) {

        System.out.println("실행결과");

        Line of1 = Line.of(5, new RandomGenerateStrategy());
        Line of2 = Line.of(5, new RandomGenerateStrategy());
        Line of3 = Line.of(5, new RandomGenerateStrategy());
        Line of4 = Line.of(5, new RandomGenerateStrategy());
        Line of5 = Line.of(5, new RandomGenerateStrategy());

        print(of1);
        print(of2);
        print(of3);
        print(of4);
        print(of5);
    }

    public void print(Line line) {
        line.getPoints()
                .forEach(point -> {
                    if (point.isLeft()) {
                        System.out.print("-----|");
                    } else {
                        System.out.print("     |");
                    }
                });
        System.out.println();
    }
}
