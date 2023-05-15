package nextstep.laddergame.view;


import nextstep.laddergame.domain.ladder.Ladder;
import nextstep.laddergame.domain.ladder.Line;
import nextstep.laddergame.domain.participant.Participants;
import nextstep.laddergame.domain.reward.Rewards;

import java.util.List;

public class OutputView {
    private static final String BLANK = "     ";
    private static final String LADDER_COLUMN = "|";
    private static final String LADDER_TRUE_ROW = "------";
    private static final String LADDER_FALSE_ROW = "      ";


    private OutputView() {
    }

    public static void printLadderResult(Participants participants, Ladder ladder, Rewards rewards) {
        System.out.println("사다리 결과");
        System.out.println();

        participants.getNames()
                .stream()
                .map(name -> BLANK + name)
                .forEach(System.out::print);
        System.out.println();

        ladder.getLinesToPrint()
                .forEach(OutputView::printLadderOneLine);

        rewards.getRewards()
                .stream()
                .map(reward -> BLANK + reward.getReward())
                .forEach(System.out::print);
    }

    private static void printLadderOneLine(Line line) {
        line.getLineToPrint()
                .forEach(point -> {
                            System.out.print(point ? LADDER_TRUE_ROW : LADDER_FALSE_ROW);
                            System.out.print(LADDER_COLUMN);
                        }
                );

        System.out.println();
    }

    public static void printRewardOnePerson(String reward) {
        System.out.println("실행 결과");
        System.out.println(reward);
    }

    public static void printRewardAll(List<String> rewards) {
        System.out.println("실행 결과");
        rewards.forEach(System.out::println);
    }
}
