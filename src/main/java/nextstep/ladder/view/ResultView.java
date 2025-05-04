package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.name.Name;
import nextstep.ladder.domain.name.Names;
import nextstep.ladder.domain.reward.Reward;
import nextstep.ladder.domain.reward.Rewards;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void ladderResult(Names names, Ladder ladder, Rewards rewards) {
        System.out.println("\n사다리 결과\n");
        for(Name name: names.values()) {
            System.out.printf("%-5s ", name.toString());
        }

        for(Line line: ladder.values()) {
            System.out.println("    " + line.toString());
        }

        for(Line line: ladder.values()) {
            System.out.println("    " + viewLine(line));
        }

        for(Reward reward: rewards.values()) {
            System.out.printf("%-5s ", reward.toString());
        }
    }

    public static String viewLine(Line line) {
        return line.values().stream()
                .map(b -> b ? "|-----" : "|     ")
                .collect(Collectors.joining())
                + "|";
    }

    public static void rewardResult(Names names, Rewards rewards, List<Integer> rewardList) {
        System.out.println("\n실행 결과");

        for(Name name: names.values()) {
            System.out.println(name + " : " + rewards.get(rewardList.get(names.positionOf(name))));
        }
    }
}
