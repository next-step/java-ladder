package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderResults;
import nextstep.ladder.model.Participants;
import nextstep.ladder.model.value.LadderResult;
import nextstep.ladder.model.value.Line;
import nextstep.ladder.model.value.Participant;
import nextstep.ladder.model.value.Point;

import java.util.stream.Collectors;

public class OutputVIew {

    private static final String WHITE_SPACE = " ";
    private static final String DRAW_LINE = "-----";
    private static final String UN_DRAW_LINE = "     ";
    private static final String DRAW_HEIGHT_LINE = "|";
    private static final String HEIGHT_SPLITTER = "\n";
    private static final String STRING_FORMAT_OF_FIVE = "%-5s";
    private static final String LINE_END_TO_END_FORMAT = "|%s";

    public void printResult(Participants participants, Ladder ladder, LadderResults ladderResults) {
        System.out.println("실행결과" + HEIGHT_SPLITTER);

        System.out.println(prettyPrintParticipantsName(participants));
        System.out.println(printLadderPretty(ladder));
        System.out.println(printLadderResultPretty(ladderResults));
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

    private String lineToPrintString(Line lines) {
        return String.format(LINE_END_TO_END_FORMAT,
                lines.getPoints().stream()
                        .map(Point::isTrue)
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

    private String printLadderResultPretty(LadderResults ladderResults) {
        return ladderResults.getLadderResults().stream()
                .map(LadderResult::getLadderResult)
                .map(this::getStringWithFormat)
                .collect(Collectors.joining(WHITE_SPACE));
    }

    private String getParticipantNameWithFormat(Participant participant) {
        return getStringWithFormat(participant.getName());
    }

    private String getStringWithFormat(String input) {
        return String.format(STRING_FORMAT_OF_FIVE, input);
    }

}
