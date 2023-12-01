package nextstep.ladder.application.service;

import nextstep.ladder.application.dto.LadderRequest;
import nextstep.ladder.application.dto.LadderResponse;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;

import java.util.stream.IntStream;

public class LadderService {

    public LadderResponse createLadder(LadderRequest request) {
        Lines lines = new Lines(request.getHighCount());
        IntStream.range(0, request.getHighCount())
                .forEach(index -> lines.addLine(new Line(request.getParticipants())));

        return new LadderResponse(lines);
    }
}
