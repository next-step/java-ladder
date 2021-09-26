package nextstep.ladder.view;

import nextstep.ladder.model.v1.Line;
import nextstep.ladder.model.v1.LineLadder;
import nextstep.ladder.model.v1.Label;
import nextstep.ladder.model.v1.Labels;
import nextstep.ladder.model.api.Ladder;

import java.util.List;

public class OutputView {
    public static final int MAX_BLANK_LENGTH = 6;

    public static void printLabels(Labels labels) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Label label : labels) {
            appendBlanks(stringBuilder, label.length());
            stringBuilder.append(label);
        }
        System.out.println(stringBuilder);
    }

    private static void appendBlanks(StringBuilder stringBuilder, int nameSize) {
        for (int i = 0; i < MAX_BLANK_LENGTH - nameSize; i++) {
            stringBuilder.append(" ");
        }
    }

    public static void printLadder(Ladder ladder) {
        for (int height = 0; height < ladder.height(); height++) {
            printLadderAtHeight(ladder, height);
        }
    }

    private static void printLadderAtHeight(Ladder ladder, int height) {
        if (ladder instanceof LineLadder) {
            System.out.print("     ");
            for (Line line : (LineLadder) ladder) {
                System.out.print(line.hasStep(height) ? "|-----" : "|     ");
            }
            System.out.println("|");
        }
    }

    public static void printResult(Label result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public static void printResultsWithNames(Labels names, List<Label> orderedResults) {
        System.out.println("실행 결과");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.at(i) + " : " + orderedResults.get(i));
        }
        System.out.println();
    }
}
