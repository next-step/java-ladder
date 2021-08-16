package step3.outputView;

import step3.domain.ladder.Ladder;
import step3.domain.ladder.LadderLine;

import java.util.List;

public class OutputView {
    public static void showLadder(Ladder ladder) {
        List<String> participants = ladder.inlineParticipants();
        List<LadderLine> ladderLines = ladder.getLadderLines();

        showNames(participants);
        showLadder(ladderLines);
    }

    private static void showNames(List<String> participants) {
        participants.forEach(s -> System.out.print("\t" + s + "\t\t"));
        System.out.println();
    }

    private static void showLadder(List<LadderLine> ladderLines) {
        ladderLines.forEach(System.out::println);
    }
}
