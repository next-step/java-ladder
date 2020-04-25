package ladder.ui;

import ladder.domain.*;
import ladder.dto.LadderRequest;
import ladder.dto.LadderResponse;

public class LadderController {
    private static final String SEPARATOR = ",";
    private final DirectionCreator directionCreator;

    public LadderController(DirectionCreator directionCreator) {
        this.directionCreator = directionCreator;
    }

    public LadderResponse run(LadderRequest ladderRequest) {
        Users users = Users.of(ladderRequest.getUserNames(), SEPARATOR);
        LadderRewards ladderRewards = LadderRewards.of(ladderRequest.getRewards(), SEPARATOR);
        LadderLineInfo ladderLineInfo = new LadderLineInfo(users.size(), directionCreator);

        Ladder ladder = Ladder.of(ladderLineInfo, ladderRequest.getHeight());
        LadderGameInfo ladderGameInfo = new LadderGameInfo(users, ladderRewards);
        LadderGame ladderGame = new LadderGame(ladder, ladderGameInfo);
        LadderGameResults ladderGameResults = ladderGame.start();
        return new LadderResponse(ladder, ladderGameInfo, ladderGameResults);
    }
}

