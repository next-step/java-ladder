package ladder.controller;

import ladder.controller.dto.*;
import ladder.domain.*;
import ladder.service.LadderGameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        Map<Participant, String> gameResults = gameService.executeGame(participants, ladder, matchingItems);
        return new LadderGameResponse(assembleLadderGenerationResult(participants, ladder, matchingItems), assembleGameResults(gameResults));
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

    private List<LadderGameResult> assembleGameResults(Map<Participant, String> gameResults) {
        List<LadderGameResult> ladderGameResults = new ArrayList<>();
        gameResults.forEach((participant, matchingItem) -> ladderGameResults.add(new LadderGameResult(participant.getName(), matchingItem)));
        return ladderGameResults;
    }
}
