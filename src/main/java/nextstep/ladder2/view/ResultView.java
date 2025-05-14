package nextstep.ladder2.view;

import nextstep.ladder2.domain.ladder.Ladder;
import nextstep.ladder2.domain.ladder.Line;
import nextstep.ladder2.domain.player.Player;
import nextstep.ladder2.domain.player.Players;
import nextstep.ladder2.domain.result.LadderResult;
import nextstep.ladder2.domain.reward.Reward;
import nextstep.ladder2.domain.reward.Rewards;

import java.util.List;

public class ResultView {
    public static void showLadder(Ladder ladder, Players players, Rewards rewards) {
        System.out.println("\n사다리 결과\n");
        for(Player player: players.values()) {
            System.out.printf("%-5s ", player.name());
        }
        System.out.println("");

        for(Line line: ladder.lines()) {
            System.out.println("    " + line);
        }

        for(Reward reward: rewards.values()) {
            System.out.printf("%-5s ", reward.toString());
        }
        System.out.println();
    }

    public static void rewardResult(Player someone, LadderResult ladderResult) {
        System.out.println("\n실행 결과");

        if (someone.name().equalsIgnoreCase("all")) {
            for (Player player : ladderResult.players().values()) {
                System.out.println(player.name() + " : " + ladderResult.rewardList().get(ladderResult.players().indexOf(player)));
            }
            return;
        }
        int idx = ladderResult.players().indexOf(someone);
        if (idx == -1) {
            System.out.println("이름이 명단에 없습니다.");
            return;
        }
        System.out.println(someone.name() + " : " + ladderResult.rewardList().get(idx));
    }
}
