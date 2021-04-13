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
        Participants participants = service.registerParticipants(request.getParticipantNames());
        Ladder ladder = service.generateLadder(participants.getCount(), request.getLadderHeight());
        GameResults gameResults = service.generateGameResults(request.getGameResults(), participants.getCount());
        return assembleResponse(participants, ladder, gameResults);
    }

    private LadderGenerationResponse assembleResponse(Participants participants, Ladder ladder, GameResults gameResults) {
        return new LadderGenerationResponse(assembleParticipantNameList(participants), Ladder.LADDER_HORIZON_WIDTH, assembleLadderLineList(ladder.getLines()), assembleGameResults(gameResults));
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

    private List<String> assembleGameResults(GameResults gameResults) {
        return gameResults.getGameResults();
    }
}
