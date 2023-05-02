package nextstep.ladder.view;

import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

public class OutputView {

    public static void resultOutput(Participants participants) {
        System.out.println("실행결과");
        System.out.println();
        String participantsView = participants.toString()
                .replace("[", "")
                .replace("] ", "")
                .replace(",", "");
        System.out.println(participantsView);
    }

    public static void printLadders(Lines lines) {
        System.out.print("    |");
        for (int i = 0; i < lines.getNumberOfLines() - 1; i++) {
            if (lines.getCurrentLine(i).hasLine()) {
                System.out.print("-----|");
            } else {
                System.out.print("     |");
            }
        }
        System.out.println();
    }
}
