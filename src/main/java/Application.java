import domain.Ladder;
import domain.User;
import utility.UserInput;
import view.View;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<User> names = UserInput.inputUserNames();

        String result = UserInput.inputResult();
        String results[] = result.split(",");
        int height = UserInput.inputHeight();

        Ladder ladder = new Ladder();
        ladder.makeLines(names, height);

        View.showNames(names);
        View.showLadder(ladder);
        View.showLadderResult(results);
        //todo : matching  name : result
        List<User> users =  ladder.startGame(names,results);

        String name = UserInput.wantToSeeName();
        View.showResult(users,name);
    }
}
