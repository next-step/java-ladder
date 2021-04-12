package ladder.controller;

import ladder.controller.dto.LadderGameRequest;
import ladder.controller.dto.LadderGameResponse;
import ladder.controller.dto.LadderLine;
import ladder.domain.*;
import ladder.service.LadderGameService;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final LadderGameService service;

    public LadderGameController() {
        this.service = new LadderGameService();
    }

    public LadderGameResponse inquiryGameResult(LadderGameRequest request) {
        Participants participants = new Participants(generateParticipants(request.getParticipantNames()));
        Ladder ladder = new Ladder(generateLines(request.getLadderLines()));
        GameResults gameResults = new GameResults(request.getGameResults());
        return new LadderGameResponse(service.inquiryGameResult(participants, ladder, gameResults, request.getInquiryTargetName()));
    }

    private List<Participant> generateParticipants(List<String> participantNames) {
        return participantNames.stream()
                .map(Participant::new)
                .collect(Collectors.toList());
    }

    private List<Line> generateLines(List<LadderLine> ladderLines) {
        return ladderLines.stream()
                .map(ladderLine -> new Line(generatePoints(ladderLine.getPoints())))
                .collect(Collectors.toList());
    }

    private List<Point> generatePoints(List<Boolean> points) {
        return points.stream()
                .map(Point::new)
                .collect(Collectors.toList());
    }

}
