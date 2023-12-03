package nextstep.ladder.application.service;

import nextstep.ladder.application.dto.LadderRequest;
import nextstep.ladder.application.dto.LadderResponse;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participants;

import java.util.stream.IntStream;

public class LadderService {

    public LadderResponse findWinner(LadderRequest request) {
        Lines lines = createLines(request);
        Participants participants = Participants.of(request.getParticipants());
        lines.moveParticipants(participants);
        participants.insertMyResult(request.getResults());
        return new LadderResponse(lines, participants);
    }

    private Lines createLines(LadderRequest request) {
        Lines lines = new Lines();
        int rowLineNumber = request.getParticipants().length - 1;
        IntStream.range(0, request.getHighCount())
                .forEach(index -> lines.addLine(new Line(rowLineNumber)));
        return lines;
    }
}
