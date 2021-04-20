package ladder.controller;

import ladder.controller.dto.LadderGameRequest;
import ladder.controller.dto.LadderGameResponse;
import ladder.controller.dto.LadderLine;
import ladder.domain.*;
import ladder.service.LadderGameService;

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
        return assembleResponse(participants, ladder, matchingItems);
    }

    private LadderGameResponse assembleResponse(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        return new LadderGameResponse(
                assembleLadderLines(ladder.getLines()),
                Ladder.LADDER_HORIZON_WIDTH,
                gameService.executeGame(participants, ladder, matchingItems));
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

}
