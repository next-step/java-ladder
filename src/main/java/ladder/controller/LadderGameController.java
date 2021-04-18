package ladder.controller;

import ladder.controller.dto.LadderGenerationRequest;
import ladder.controller.dto.LadderGenerationResponse;
import ladder.controller.dto.LadderLine;
import ladder.domain.*;
import ladder.service.LadderGameService;
import ladder.service.LadderGenerationService;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {

    private final LadderGenerationService generationService;
    private final LadderGameService gameService;

    public LadderGameController() {
        this.generationService = new LadderGenerationService();
        this.gameService = new LadderGameService();
    }

    public LadderGenerationResponse executeLadderGame(LadderGenerationRequest request) {
        Participants participants = generationService.registerParticipants(request.getParticipantNames());
        Ladder ladder = generationService.generateLadder(participants.getCount(), request.getLadderHeight());
        MatchingItems matchingItems = generationService.generateMatchingItems(request.getMatchingItems(), participants.getCount());
        return assembleResponse(participants, ladder, matchingItems);
    }

    private LadderGenerationResponse assembleResponse(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        return new LadderGenerationResponse(
                assembleParticipantNameList(participants),
                Ladder.LADDER_HORIZON_WIDTH,
                assembleLadderLineList(ladder.getLines()),
                assembleMatchingItems(matchingItems),
                gameService.executeGame(participants, ladder, matchingItems));
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
        List<Boolean> pointList = line.getPoints().stream().map(Point::hasRightLine).collect(Collectors.toList());
        return new LadderLine(pointList);
    }

    private List<String> assembleMatchingItems(MatchingItems matchingItems) {
        return matchingItems.getMatchingItems();
    }

}
