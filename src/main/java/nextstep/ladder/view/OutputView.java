package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Ladders;
import nextstep.ladder.model.Name;
import nextstep.ladder.model.Names;

public class OutputView {
    public static void printNames(Names names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Name name : names) {
            stringBuilder.append(name.toString());
            appendBlanks(stringBuilder, name.length());
        }
        System.out.println(stringBuilder);
    }

    private static void appendBlanks(StringBuilder stringBuilder, int nameSize) {
        for (int i = 0; i < 6 - nameSize; i++) {
            stringBuilder.append(" ");
        }
    }

    public static void printLadders(Ladders ladders) {
        for (int height = 0; height < ladders.height(); height++) {
            printLaddersAtHeight(ladders, height);
        }
    }

    private static void printLaddersAtHeight(Ladders ladders, int height) {
        for (Ladder ladder : ladders) {
            System.out.print(ladder.hasStep(height) ? "|-----" : "|     ");
        }
        System.out.println("|");
    }
}
