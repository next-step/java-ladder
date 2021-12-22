package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.strategy.PointStrategy;
import nextstep.ladder.strategy.RandomPointStrategy;

import static nextstep.ladder.view.InputView.*;
import static nextstep.ladder.view.InputView.requestLadderLayer;
import static nextstep.ladder.view.ResultView.*;

public class LadderApplication {
    public static void main(String[] args) {
        Members members = Members.from(requestMemberNames());
        Rewards rewards = Rewards.of(requestRewards(), members);
        LadderLayer ladderLayer = new LadderLayer(requestLadderLayer());

        PointStrategy pointStrategy = new RandomPointStrategy();
        Ladder ladder = Ladder.of(members, ladderLayer, pointStrategy);

        responseInitMessage();
        responseLadderMembers(members);
        responseLadder(ladder);
        responseRewards(rewards);
        responseResults(requestResultMember(), LadderResults.of(members, rewards, ladder));
    }
}
