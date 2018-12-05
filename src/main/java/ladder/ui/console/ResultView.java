package ladder.ui.console;

import ladder.model.Ladder;
import ladder.model.LadderGame;
import ladder.model.LadderResult;
import ladder.model.Line;
import ladder.model.People;
import ladder.model.Rewards;

import java.util.List;

public class ResultView {
    private static final String TRUE_POINT = "-----|";
    private static final String FALSE_POINT = "     |";

    public static void showLadder(LadderGame ladderGame) {
        System.out.println("실행결과");

        People people = ladderGame.getPeople();
        Rewards rewards = ladderGame.getRewards();

        people.getPeople().stream().forEach(person -> {
            System.out.print(String.format("%6s", person.getName()));
        });
        System.out.println();

        Ladder ladder = ladderGame.getLadder();

        ladder.getLines().stream().forEach(line -> {
            List<Boolean> points = line.getPoints();
            points.stream().forEach(point-> System.out.print(point ? TRUE_POINT : FALSE_POINT));
            System.out.println();
        });

        rewards.getRewards().stream().forEach(reward -> {
            System.out.print(String.format("%6s", reward.getReward()));
        });
        System.out.println();
    }


    public static void ladderResult(LadderResult ladderResult, String person) {
        if(person.equals("all")) {
            return;
        }

        System.out.println("실행 결과");
        System.out.println(ladderResult.getRewardByPerson(person).getReward());
    }
}
