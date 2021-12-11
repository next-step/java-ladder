package nextstep.ladder.view;

import static nextstep.ladder.view.PrintUtils.print;
import static nextstep.ladder.view.PrintUtils.printSpace;

import java.util.stream.Collectors;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Participants;

public class OutputView {

    private static final String WHITE_SPACE = " ";
    private static final String DRAW_LINE = "-----";
    private static final String UN_DRAW_LINE = "     ";
    private static final String DRAW_HEIGHT_LINE = "|";
    private static final String HEIGHT_SPLITTER = "\n";
    private static final String STRING_FORMAT_OF_FIVE = "%-5s";
    private static final String LINE_END_TO_END_FORMAT = "|%s";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String GAME_RESULT_MESSAGE = "실행 결과";

    public void printLadder(Participants participants, Ladder ladder, LadderResults ladderResults) {
        print(LADDER_RESULT_MESSAGE);

        print(prettyPrintParticipantsName(participants));
        print(printLadderPretty(ladder));
        print(printLadderResultPretty(ladderResults));
    }


    public void printResult(Participant participant, LadderResults ladderResults) {
        printSpace();
        print(GAME_RESULT_MESSAGE);
        print(ladderResults.get(participant));
    }

    public void printAllResult(Participants participants, LadderResults ladderResults) {
        print(GAME_RESULT_MESSAGE);

        participants.getParticipants().stream()
            .map(participant -> participant.getName() + " : " + ladderResults.get(participant))
            .forEach(PrintUtils::print);
    }

    private String prettyPrintParticipantsName(Participants participants) {
        return participants.getParticipants().stream()
            .map(this::getParticipantNameWithFormat)
            .collect(Collectors.joining(WHITE_SPACE));
    }

    private String printLadderPretty(Ladder ladder) {
        return ladder.getLines().stream()
            .map(this::lineToPrintString)
            .collect(Collectors.joining(HEIGHT_SPLITTER));
    }

    private String printLadderResultPretty(LadderResults ladderResults) {
        return ladderResults.getResults().stream()
            .map(this::getStringWithFormat)
            .collect(Collectors.joining(WHITE_SPACE));
    }

    private String lineToPrintString(Line lines) {
        return String.format(LINE_END_TO_END_FORMAT,
            lines.getPoints().stream()
                .map(this::getBooleanStringFunction)
                .map(line -> line + DRAW_HEIGHT_LINE)
                .collect(Collectors.joining()));
    }

    private String getBooleanStringFunction(boolean isPoint) {
        if (isPoint) {
            return DRAW_LINE;
        }
        return UN_DRAW_LINE;
    }

    private String getParticipantNameWithFormat(Participant participant) {
        return getStringWithFormat(participant.getName());
    }

    private String getStringWithFormat(String input) {
        return String.format(STRING_FORMAT_OF_FIVE, input);
    }

}
