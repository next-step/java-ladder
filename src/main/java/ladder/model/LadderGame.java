package ladder.model;

public class LadderGame {
    private Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public GameResult play(Participants participants, ResultItems resultItems) {
        if (!ladder.isMatchPointCount(participants.size()) || !ladder.isMatchPointCount(resultItems.size())) {
            throw new IllegalArgumentException();
        }

        GameResult gameResult = new GameResult();
        for (int i = 0, len = participants.size(); i < len; i++) {
            gameResult.addResult(participants.match(i), resultItems.match(play(i)));
        }
        return gameResult;
    }

    public int play(int beginIndex) {
        return ladder.moveFrom(beginIndex);
    }
}
