package ladder.controller;

import ladder.controller.dto.LadderGameRequest;
import ladder.controller.dto.LadderGameResponse;
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

    public LadderGameResponse executeLadderGame(LadderGameRequest request) {
        Participants participants = generationService.registerParticipants(request.getParticipantNames());
        Ladder ladder = generationService.generateLadder(participants.getCount(), request.getLadderHeight());
        MatchingItems matchingItems = generationService.generateMatchingItems(request.getMatchingItems(), participants.getCount());
        return assembleResponse(participants, ladder, matchingItems);
    }

    private LadderGameResponse assembleResponse(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        return new LadderGameResponse(
                assembleParticipantNames(participants),
                Ladder.LADDER_HORIZON_WIDTH,
                assembleLadderLines(ladder.getLines()),
                assembleMatchingItems(matchingItems),
                gameService.executeGame(participants, ladder, matchingItems));
    }

    private List<String> assembleParticipantNames(Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    private List<LadderLine> assembleLadderLines(List<Line> lineList) {
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
