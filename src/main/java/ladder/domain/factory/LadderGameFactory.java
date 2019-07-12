package ladder.domain.factory;

import ladder.domain.*;

public class LadderGameFactory {

    private LadderGameFactory() {}

    public static LadderGame createLadderGame(LadderGameInfo ladderGameInfo) {

        GameInfo gameInfo = GameInfo.of(new Participants(ladderGameInfo.getParticipantNames()), new Goals(ladderGameInfo.getGoals()));
        Lines lines = LinesFactory.createLines(gameInfo.getLadderWidth(), ladderGameInfo.getHeight());

        return new LadderGame(gameInfo, lines);
    }
}
