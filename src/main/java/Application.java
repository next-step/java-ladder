import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.strategy.RandomGenerateStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final Users users = new Users(InputView.inputUserNames());
        final Ladder ladder = new Ladder(InputView.maxLength(), users, new RandomGenerateStrategy());
        OutputView.printLadderResult(users, ladder);
    }
}
