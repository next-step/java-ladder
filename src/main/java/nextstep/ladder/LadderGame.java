package nextstep.ladder;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.generator.LadderGenerator;
import nextstep.ladder.domain.name.Name;
import nextstep.ladder.domain.name.Names;
import nextstep.ladder.domain.resolver.LadderResolver;
import nextstep.ladder.domain.reward.Reward;
import nextstep.ladder.domain.reward.Rewards;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        Names names = new Names(InputView.getNames());
        Height height = new Height(InputView.getHeight());
        Rewards rewards = new Rewards(InputView.getRewards());

        Ladder ladder = LadderGenerator.generateLadder(names.count(), height);

        ResultView.ladderResult(names, ladder);

        LadderResolver resolver = new LadderResolver(ladder);
        while(true) {
            String playerName = InputView.getPlayerName();

            if (playerName.equalsIgnoreCase("quit")) {
                break;
            }

            if (playerName.equalsIgnoreCase("all")) {
                List<Integer> rewardList = resolver.all();
                ResultView.rewardResult(names, rewards, rewardList);
                continue;
            }

            Name name = new Name(playerName);
            int rewardIdx = resolver.resultOf(names.positionOf(name));
            try {
                Reward reward = rewards.get(rewardIdx);
                System.out.println(reward);
            } catch(IndexOutOfBoundsException e) {
                System.out.println("이름이 명단에 없습니다.");
            }
        }
    }
}
