package step4.outputView;

import step4.domain.ladder.Ladder;
import step4.domain.ladder.LadderLine;

import java.util.List;
import java.util.stream.Collectors;

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
        for (LadderLine ladderLine : ladderLines) {
            ladderLine.getLine()
                .stream()
                .map(LadderShape::of)
                .collect(Collectors.toList())
                .forEach(System.out::print);
            System.out.println();
        }
    }

    public static void showResultOf(String name, String resultOf) {
        System.out.println(name + " : " + resultOf);
    }

    public static void showResultTest() {
        System.out.println("실행 결과");
    }
}
