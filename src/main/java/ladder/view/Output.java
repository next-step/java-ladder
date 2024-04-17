package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participants;
import ladder.domain.Results;

import java.util.Map;
import java.util.stream.StreamSupport;

public class Output {
    private static final String HORIZONTAL = "-----";
    private static final String VERTICAL = "|";
    private static final String SPACE = "     ";
    private static final String NEW_LINE = "\n";

    public static void showGameView(Participants participants, Ladder ladder, Results results) {
        StringBuilder sb = new StringBuilder();

        sb.append("실행 결과").append(NEW_LINE);

        sb.append(showParticipants(participants)).append(NEW_LINE);
        sb.append(showLadder(ladder));
        sb.append(showResults(results)).append(NEW_LINE);

        System.out.println(sb);
    }

    public static void showIndividualResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void showAllResult(Map<String, String> result) {
        System.out.println("실행 결과");
        result.forEach((participant, individualResult) -> System.out.println(participant + " : " + individualResult));
    }

    public static String showParticipants(Participants participants) {
        StringBuilder sb = new StringBuilder();

        for (String participant: participants) {
            sb.append(String.format("%6s", participant));
        }

        return sb.toString();
    }

    public static String showResults(Results results) {
        StringBuilder sb = new StringBuilder();

        for (String result: results) {
            sb.append(String.format("%6s", result));
        }

        return sb.toString();
    }


    public static String showLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        StreamSupport.stream(ladder.spliterator(), false)
                .forEach(line -> sb.append(SPACE).append(Output.showLine(line)));

        return sb.toString();
    }

    public static String showLine(Line line) {
        StringBuilder sb = new StringBuilder();

        sb.append(VERTICAL);
        StreamSupport.stream(line.spliterator(), false)
                        .map(point -> point ? HORIZONTAL : SPACE)
                                .forEach(character -> sb.append(character).append(VERTICAL));
        sb.append(NEW_LINE);

        return sb.toString();
    }
}
