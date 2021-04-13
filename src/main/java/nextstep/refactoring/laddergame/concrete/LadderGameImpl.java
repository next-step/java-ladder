package nextstep.refactoring.laddergame.concrete;

import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.LadderResult;
import nextstep.refactoring.laddergame.engine.LadderCompatibleList;
import nextstep.refactoring.laddergame.engine.LadderGame;
import nextstep.refactoring.laddergame.engine.LadderGameResult;
import nextstep.refactoring.laddergame.engine.PlayerNameKeyword;
import nextstep.refactoring.laddergame.engine.player.Player;
import nextstep.refactoring.laddergame.engine.reward.Reward;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameImpl implements LadderGame {

    private final Ladder ladder;

    public LadderGameImpl(Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public List<LadderGameResult> getResult(LadderCompatibleList<Player> playerList,
                                            LadderCompatibleList<Reward> rewardList,
                                            PlayerNameKeyword playerNameKeyword) {
        if (playerList.isNotCompatible(ladder) || rewardList.isNotCompatible(ladder) ) {
            throw new IllegalArgumentException("요소 개수가 사다리 지점의 개수와 일치해야 합니다.");
        }

        return playerList.stream().filter(playerNameKeyword.createCondition())
                  .map(Player::getPosition)
                  .map(ladder::run)
                  .map(ladderResult -> createLadderGameResult(playerList, rewardList, ladderResult))
                  .collect(Collectors.toList());
    }

    private LadderGameResult createLadderGameResult(LadderCompatibleList<Player> playerList,
                                                    LadderCompatibleList<Reward> rewardList,
                                                    LadderResult result) {
        return new LadderGameResultImpl(playerList.get(result.getStartPosition()),
            rewardList.get(result.getEndPosition()));
    }

}
