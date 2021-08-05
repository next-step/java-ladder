package nextstep.ladder.view;

import nextstep.ladder.LadderName;
import nextstep.ladder.Line;

import java.util.Random;

public class ResultView {
    private static final Random random = new Random();
    private static final String LINE = "-----|";
    private static final String NONE_LINE = "     |";
    private static final int DIVIDE_NUMBER = 2;
    private static final int DO_NOT_MAKE_ZERO = 1;


    public void print(LadderName ladderName, int maxLadderHeight) {
        printLadderName(ladderName);
        println(ladderName, maxLadderHeight);
    }

    public void println(LadderName ladderName, int maxLadderHeight) {
        for(int i = 0; i < maxLadderHeight; i++) {
            System.out.println(new Line(ladderName.size(), () -> random.nextInt(DIVIDE_NUMBER) + DO_NOT_MAKE_ZERO));
        }
    }

    public void printLadderName(LadderName ladderName) {
        System.out.println(ladderName.toString().replaceAll("\\[|\\]", "").replaceAll(",", ""));
    }

    public static String addNoneLine() {
        return NONE_LINE;
    }

    public static String addLine() {
        return LINE;
    }
}
