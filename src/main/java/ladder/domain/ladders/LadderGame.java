package ladder.domain.ladders;

import ladder.domain.ladders.ladder.Ladder;
import ladder.domain.ladders.reward.GameRewards;
import ladder.domain.ladders.reward.Prize;
import ladder.domain.participants.Position;
import ladder.utils.SplitUtils;

public class LadderGame {

    private final Ladder ladder;
    private final GameRewards gameRewards;

    public LadderGame(int height, String inputText, PointPredicate predicate) {
        this(
                new Ladder(height, SplitUtils.split(inputText).length, predicate),
                new GameRewards(inputText)
        );
    }

    public LadderGame(Ladder ladder, GameRewards gameRewards) {
        this.ladder = ladder;
        this.gameRewards = gameRewards;
    }

    public Prize getRewardBy(Position position) {
        Position move = ladder.move(position);
        return gameRewards.getRewardByPosition(move);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public GameRewards getGameRewards() {
        return gameRewards;
    }
}
