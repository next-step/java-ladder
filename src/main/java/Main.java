import constant.Question;
import domain.Ladder;
import domain.LadderReward;
import domain.Players;
import util.GenerateLadderLine;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        final Players players = new Players(InputView.StringQuestion(Question.PLEASE_ENTER_THE_NAME_OF_THE_PARTICIPANT));
        final LadderReward reward = new LadderReward(InputView.StringQuestion(Question.ENTER_EXECUTION_RESULT), players);
        final Ladder ladder = new Ladder(players, InputView.IntegerQuestion(Question.HOW_TALL_IS_THE_MAXIMUM_LADDER), new GenerateLadderLine());

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printRewards(reward);

        boolean isStop = true;
        while (isStop) {
            final String player = InputView.getInputPlayer();
            if (!"all".equals(player.toLowerCase())) {
                System.out.println(Question.EXECUTION_RESULTS);
                System.out.println(reward.findReward(players.findByName(player)));
            }
            if ("all".equals(player.toLowerCase())) {
                System.out.println();
                for (int i = 0; i < players.size(); i++) {
                    final String name = players.findPlayerByIndex(i).getName();
                    System.out.println(name + " : " + reward.findReward(players.findByName(name)));
                }
                isStop = false;
            }
        }

    }

}
