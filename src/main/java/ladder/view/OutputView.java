package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Ladder;
import ladder.domain.LadderGameResult;
import ladder.domain.Line;
import ladder.domain.Participant;
import ladder.domain.Link;

public class OutputView {

    private static final String LADDER_HEADER_MESSAGE = "실행결과\n";
    private static final String WHOLE_GAME_RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String WHOLE_GAME_RESULT_FORMAT = "%s : %s\n";
    private static final String FIRST_PARTICIPANT_COLUMN = "    |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String NO_HORIZONTAL_LINE = "     |";
    private static final String NAME_FORMAT = "%5s";
    private static final String RESULT_FORMAT = "%5s";
    private static final String NAME_DELIMITER = " ";
    private static final String RESULT_DELIMITER = " ";

    public void printLine() {
        System.out.println();
    }

    public void printLadder(Ladder ladder, List<Participant> participants, List<String> results) {
        System.out.println(LADDER_HEADER_MESSAGE);
        printNames(participants);

        List<Line> lines = ladder.lines();
        lines.forEach(this::printLine);
        String strResults = results.stream()
            .map(result -> String.format(RESULT_FORMAT, result))
            .collect(Collectors.joining(RESULT_DELIMITER));
        System.out.println(strResults);
    }

    private void printNames(List<Participant> participants) {
        String strNames = participants.stream()
            .map(Participant::name)
            .map(name -> String.format(NAME_FORMAT, name))
            .collect(Collectors.joining(NAME_DELIMITER));
        System.out.println(strNames);
    }

    private void printLine(Line line) {
        List<Link> links = line.links();
        System.out.print(FIRST_PARTICIPANT_COLUMN);
        int secondFromBackIndex = links.size() - 2;
        for (int i = 0; i <= secondFromBackIndex; i++) {
            printLink(links.get(i));
        }
        printLine();
    }

    private void printLink(Link link) {
        if (link == Link.RIGHT_LINK) {
            System.out.print(HORIZONTAL_LINE);
            return;
        }
        System.out.print(NO_HORIZONTAL_LINE);
    }

    public void printWholeGameResult(List<Participant> participants, LadderGameResult gameResult) {
        System.out.println(WHOLE_GAME_RESULT_HEADER_MESSAGE);
        for (Participant participant : participants) {
            String result = gameResult.get(participant);
            System.out.printf(WHOLE_GAME_RESULT_FORMAT, participant.name(), result);
        }
    }

    public void printGameResult(Participant participant, LadderGameResult gameResult) {
        String result = gameResult.get(participant);
        System.out.println(result);
    }
}
