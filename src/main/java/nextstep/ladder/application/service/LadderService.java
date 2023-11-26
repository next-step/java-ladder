package nextstep.ladder.application.service;

import nextstep.ladder.application.dto.LadderRequest;
import nextstep.ladder.application.dto.LadderResponse;
import nextstep.ladder.domain.calculator.CalculatorFactory;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;

public class LadderService {

    public LadderResponse createLadder(LadderRequest request) {
        CalculatorFactory factory = new CalculatorFactory(request.getParticipants());
        Lines lines = new Lines(request.getHighCount());
        lines.addLineByHighCount(new Line(factory));

        return null;
    }
}
