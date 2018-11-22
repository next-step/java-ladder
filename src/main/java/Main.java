import constant.Question;
import domain.Ladder;
import domain.Players;
import util.GenerateLadderLine;
import view.InputView;
import view.ResultView;

public class Main {

    public static void main(String[] args) {

        final Players players = new Players(InputView.StringQuestion(Question.PLEASE_ENTER_THE_NAME_OF_THE_PARTICIPANT));
        final Ladder ladder = new Ladder(players, InputView.IntegerQuestion(Question.HOW_TALL_IS_THE_MAXIMUM_LADDER), new GenerateLadderLine());

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);

    }

}
