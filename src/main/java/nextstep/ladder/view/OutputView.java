package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.ParticipantNames;

import java.util.stream.Collectors;

public class OutputView {
    private static final String PARTICIPANT_NAME_FORMAT = "%5s ";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_EMPTY_SPACE = "     ";
    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_SPACE = " ";
    private static final String NEWLINE = System.lineSeparator();

    private OutputView() {
    }

    public static void printParticipantNamesAndLadders(LadderGame ladderGame) {
        System.out.println("실행 결과" + NEWLINE);

        String output = formatParticipantNames(ladderGame.getParticipantNames()) +
                formatLines(ladderGame.getParticipantNames().getFirstParticipantNameLength(), ladderGame.getLines());

        System.out.println(output);
    }

    private static String formatParticipantNames(ParticipantNames participantNames) {
        int lastIndex = participantNames.getNames().size() - 1;

        String names = participantNames.getNames().stream()
                .limit(lastIndex)
                .map(participantName -> String.format(PARTICIPANT_NAME_FORMAT, participantName.getName()))
                .collect(Collectors.joining());

        return names + String.format(PARTICIPANT_NAME_FORMAT, participantNames.getNames().get(lastIndex).getName()) + NEWLINE;
    }


    private static String formatLines(int firstParticipantNameLength, Lines lines) {
        return lines.getLines().stream()
                .map(line -> formatSingleLine(firstParticipantNameLength, line))
                .collect(Collectors.joining(NEWLINE)) + NEWLINE;
    }

    private static String formatSingleLine(int firstParticipantNameLength, Line line) {
        StringBuilder ladder = new StringBuilder(LADDER_SPACE.repeat(firstParticipantNameLength) + LADDER_VERTICAL_LINE);

        line.getPoints().stream()
                .map(point -> point ? LADDER_HORIZONTAL_LINE : LADDER_EMPTY_SPACE)
                .forEach(segment -> ladder.append(segment).append(LADDER_VERTICAL_LINE));

        return ladder.toString();
    }
}
