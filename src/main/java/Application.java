import domain.Ladder;
import domain.User;
import utility.UserInput;
import view.View;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> users = UserInput.inputUserNames();

        String result = UserInput.inputResult();
        String results[] = result.split(",");
        int height = UserInput.inputHeight();

        Ladder ladder = new Ladder();
        ladder.makeLines(users, height);

        View.showNames(users);
        View.showLadder(ladder);
        View.showLadderResult(results);

        ladder.startGame(users, results);

        View.showResult(users, UserInput.showNameWantToSee());
    }
}
