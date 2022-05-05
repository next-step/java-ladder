package ladder;

import ladder.domain.Line;

public class Controller {
    public static void main(String[] args) {
        Line line = new Line(5);
        System.out.println(line.getLine().toString());

        line = new Line(6);
        System.out.println(line.getLine().toString());

        line = new Line(3);
        System.out.println(line.getLine().toString());
    }
}
