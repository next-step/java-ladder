package ladder.controller;

import ladder.controller.dto.LadderGenerationRequest;
import ladder.controller.dto.LadderGenerationResponse;
import ladder.controller.dto.LadderLine;
import ladder.domain.*;
import ladder.service.LadderGenerationService;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGenerationController {

    private final LadderGenerationService service;

    public LadderGenerationController() {
        this.service = new LadderGenerationService();
    }

    public LadderGenerationResponse generateLadder(LadderGenerationRequest request) {
        return assembleResponse(service.generateLadderGame(request.getParticipantNames(), request.getLadderHeight()));
    }

    private LadderGenerationResponse assembleResponse(LadderGame ladderGame) {
        return new LadderGenerationResponse(assembleParticipantNameList(ladderGame.getParticipants()), LadderGame.LADDER_HORIZON_WIDTH, assembleLadderLineList(ladderGame.getLines()));
    }

    private List<String> assembleParticipantNameList(Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    private List<LadderLine> assembleLadderLineList(List<Line> lineList) {
        return lineList.stream()
                .map(this::assembleLadderLine)
                .collect(Collectors.toList());
    }

    private LadderLine assembleLadderLine(Line line) {
        List<Boolean> pointList = line.getPoints().stream().map(Point::hasLine).collect(Collectors.toList());
        return new LadderLine(pointList);
    }
}
