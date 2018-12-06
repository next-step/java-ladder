import constant.Question;
import domain.Ladder;
import domain.Players;
import domain.Reward;
import view.InputView;
import view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {

        final Players players = new Players(InputView.stringQuestion(Question.PLEASE_ENTER_THE_NAME_OF_THE_PARTICIPANT));
        final Reward reward = new Reward(InputView.stringQuestion(Question.ENTER_EXECUTION_RESULT), players);
        final Ladder ladder = new Ladder(players, InputView.integerQuestion(Question.HOW_TALL_IS_THE_MAXIMUM_LADDER));

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printRewards(reward);

        boolean isStop = true;
        while (isStop) {
            final String playerName = InputView.getInputPlayer();
            if (!"all".equals(playerName.toLowerCase())) {
                System.out.println(Question.EXECUTION_RESULTS);
                System.out.println(reward.findReward(ladder.move(players.findByName(playerName))));
            }
            if ("all".equals(playerName.toLowerCase())) {
                System.out.println();
                for (int i = 0; i < players.size(); i++) {
                    final String name = players.findPlayerByIndex(i).getName();
                    System.out.println(name + " : " + reward.findReward(ladder.move(players.findByName(name))));
                }
                isStop = false;
            }
        }

    }

}
