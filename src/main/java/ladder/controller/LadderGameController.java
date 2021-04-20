package ladder.controller;

import ladder.controller.dto.LadderGameRequest;
import ladder.controller.dto.LadderGameResponse;
import ladder.controller.dto.LadderGenerationResult;
import ladder.controller.dto.LadderLine;
import ladder.domain.*;
import ladder.service.LadderGameService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameController {
    
    private final LadderGameService gameService;

    public LadderGameController() {
        this.gameService = new LadderGameService();
    }

    public LadderGameResponse executeLadderGame(LadderGameRequest request) {
        Participants participants = gameService.registerParticipants(request.getParticipantNames());
        Ladder ladder = gameService.generateLadder(participants.getCount(), request.getLadderHeight());
        MatchingItems matchingItems = gameService.generateMatchingItems(request.getMatchingItems(), participants.getCount());
        return new LadderGameResponse(assembleLadderGenerationResult(participants, ladder, matchingItems),gameService.executeGame(participants, ladder, matchingItems));
    }

    private LadderGenerationResult assembleLadderGenerationResult(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        return new LadderGenerationResult(assembleParticipants(participants), assembleLadderLines(ladder), Ladder.LADDER_HORIZON_WIDTH, assembleMatchingItems(matchingItems));
    }

    private List<String> assembleParticipants(Participants participants) {
        return participants.getParticipants().stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    private List<LadderLine> assembleLadderLines(Ladder ladder) {
        return ladder.getLines().stream()
                .map(this::assembleLadderLine)
                .collect(Collectors.toList());
    }

    private List<String> assembleMatchingItems(MatchingItems matchingItems) {
        return new ArrayList<>(matchingItems.getMatchingItems());
    }

    private LadderLine assembleLadderLine(Line line) {
        List<Boolean> pointList = line.getPoints().stream().map(Point::hasRightLine).collect(Collectors.toList());
        return new LadderLine(pointList);
    }

}
