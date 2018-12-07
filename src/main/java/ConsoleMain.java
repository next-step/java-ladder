import constant.Question;
import domain.Ladder;
import domain.Level;
import domain.Players;
import domain.Reward;
import util.DirectionGenerator;
import view.InputView;
import view.ResultView;

public class ConsoleMain {

    public static void main(String[] args) {

        final Players players = new Players(InputView.stringQuestion(Question.PLEASE_ENTER_THE_NAME_OF_THE_PARTICIPANT));
        final Reward reward = new Reward(InputView.stringQuestion(Question.ENTER_EXECUTION_RESULT), players);
        final Level level = Level.from(InputView.stringQuestion(Question.HOW_DIFFICULT_IS_THE_LADDER_TO_EXECUTE));
        final Ladder ladder = new Ladder(players, level.getHeight(), new DirectionGenerator(level.getWeight()));

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
