package ladder.service;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.dto.LadderRequest;
import ladder.dto.LadderResponse;

import java.util.stream.IntStream;

public class LadderService {
    public LadderResponse createLadder(LadderRequest request) {
        Lines lines = new Lines(request.getLimitCount());
        IntStream.range(0, request.getLimitCount())
                 .forEach(i -> lines.addLine(new Line(request.getParticipants())));

        return new LadderResponse(lines);
    }
}
