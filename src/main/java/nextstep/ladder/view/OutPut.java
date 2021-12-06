package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;

public class OutPut {

    public static void viewLadder(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print("|");
            line.getPoints().stream().forEach(point -> {
                if (point == true) {
                    System.out.print("-----|");
                }
                else{
                    System.out.print("     |");
                }
            });
            System.out.println("");
        }
    }
}
