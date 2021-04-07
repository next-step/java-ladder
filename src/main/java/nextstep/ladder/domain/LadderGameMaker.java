package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderFactory;
import nextstep.ladder.domain.ladder.RandomLineFactory;
import nextstep.ladder.domain.player.Players;

public class LadderGameMaker {

    private static final LadderFactory randomLadderFactory = new LadderFactory(new RandomLineFactory());

    private LadderGameMaker() {}

    public static LadderGame makeRandomLadderGame(Players players, Rewards rewards, int ladderHeight) {
        validateSize(players, rewards);

        Ladder ladder = randomLadderFactory.createLadder(ladderHeight, players.getSize());

        LadderBoard ladderBoard = new LadderBoard(ladder, rewards);

        return new LadderGame(players, ladderBoard);
    }

    private static void validateSize(Players players, Rewards rewards) {
        if (players.getSize() != rewards.getSize()) {
            throw new IllegalArgumentException("참가자 수만큼의 보상이 필요합니다.");
        }
    }

}
