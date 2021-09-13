package nextstep.ladder.view;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Label;
import nextstep.ladder.model.Labels;

public class OutputView {

    public static final int MAX_BLANK_LENGTH = 6;

    public static void printLabels(Labels labels) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Label label : labels) {
            stringBuilder.append(label.toString());
            appendBlanks(stringBuilder, label.length());
        }
        System.out.println(stringBuilder);
    }

    private static void appendBlanks(StringBuilder stringBuilder, int nameSize) {
        for (int i = 0; i < MAX_BLANK_LENGTH - nameSize; i++) {
            stringBuilder.append(" ");
        }
    }

    public static void printLadders(Ladder ladder) {
        for (int height = 0; height < ladder.height(); height++) {
            printLaddersAtHeight(ladder, height);
        }
    }

    private static void printLaddersAtHeight(Ladder ladder, int height) {
        for (Line line : ladder) {
            System.out.print(line.hasStep(height) ? "|-----" : "|     ");
        }
        System.out.println("|");
    }

    public static void printResult(Label result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }
}
