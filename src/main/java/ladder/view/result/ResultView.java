package ladder.view.result;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Participants;

import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {
    }

    public static void printLadder(Participants participants, Ladder ladder) {
        System.out.println("실행결과");
        String participantsDraw = participants.getParticipants().stream()
                .map(ResultView::drawPerson)
                .collect(Collectors.joining());
        System.out.println(participantsDraw);

        String ladderDraw = ladder.getLadder().stream()
                .map(ResultView::drawLine)
                .collect(Collectors.joining());
        System.out.println(ladderDraw);

    }

    private static String drawLine(Line line) {
        StringBuilder sb = new StringBuilder("    |");
        String result = line.getPoints().stream()
                .map(bool -> bool ? "-----|" : "     |")
                .collect(Collectors.joining());
        sb.append(result);
        return sb.append("\n").toString();
    }

    private static String drawPerson(String name) {
        StringBuilder sb = new StringBuilder(name);
        while (sb.length() < 5) {
            sb.insert(0, " ");
        }
        return sb.append(" ").toString();
    }
}
