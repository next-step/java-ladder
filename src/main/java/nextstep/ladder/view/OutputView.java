package nextstep.ladder.view;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Name;
import nextstep.ladder.model.Names;

public class OutputView {

    public static final int MAX_BLANK_LENGTH = 6;

    public static void printNames(Names names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Name name : names) {
            stringBuilder.append(name.toString());
            appendBlanks(stringBuilder, name.length());
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
}
