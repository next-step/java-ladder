package ladder.view;

import ladder.domain.Line;

import java.util.List;

public class LadderOutput {
    private static final String LADDER_DRAW_RESULT = "실행결과";
    private static final String DIGITS = "6";

    public static void drawLadder(List<Line> ladder) {
        System.out.println(LADDER_DRAW_RESULT);

        for (Line line : ladder) {
            System.out.println();
            for (String l : line.getLine()) {
                System.out.print(String.format("%" + DIGITS + "s", l));
            }
        }
    }

}
