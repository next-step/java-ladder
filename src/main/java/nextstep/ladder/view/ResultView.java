package nextstep.ladder.view;

import nextstep.common.Assert;
import nextstep.ladder.view.dto.LadderResponse;
import nextstep.ladder.view.dto.ParticipantResultResponse;
import nextstep.ladder.view.dto.ResultResponse;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {

    private static final String CONNECTED_POINT_LINE_MESSAGE = "-----";
    private static final String DISCONNECTED_POINT_LINE_MESSAGE = "     ";
    private static final char POINT_MESSAGE = '|';
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String PARTICIPANT_RESULT_FORMAT = "%s:%s\n";
    private static final String ENVIRONMENT_FORMAT = "%-6s";

    private final PrintStream printer;

    private ResultView(PrintStream printer) {
        Assert.notNull(printer, "printer must not be null");
        this.printer = printer;
    }

    public static ResultView from(PrintStream output) {
        return new ResultView(output);
    }

    public void print(LadderResponse ladder) {
        printer.println(LADDER_RESULT_MESSAGE);
        ladder.getParticipants().forEach(participant -> printer.printf(ENVIRONMENT_FORMAT, participant));
        printer.println();
        ladder.getLines().forEach(line -> printer.println(lineMessage(line)));
        ladder.getResults().forEach(result -> printer.printf(ENVIRONMENT_FORMAT, result));
        printer.println();
    }

    public void print(ResultResponse result) {
        printer.println(RESULT_MESSAGE);
        printer.println(result.getValue());
    }

    public void print(List<ParticipantResultResponse> participantResults) {
        printer.println(RESULT_MESSAGE);
        participantResults.forEach(participantResult ->
                printer.printf(PARTICIPANT_RESULT_FORMAT, participantResult.getParticipant(), participantResult.getResult()));
    }

    private String lineMessage(List<Boolean> connections) {
        return connections.stream()
                .map(connection -> POINT_MESSAGE + connectionMessage(connection))
                .collect(Collectors.joining());
    }

    private String connectionMessage(boolean connected) {
        if (connected) {
            return CONNECTED_POINT_LINE_MESSAGE;
        }
        return DISCONNECTED_POINT_LINE_MESSAGE;
    }
}
