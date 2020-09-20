import domain.Ladder;
import domain.UserName;
import utility.UserInput;
import view.View;

import java.util.List;

public class Application {
    public static void main(String[] args) {
//        String names = UserInput.inputUserNames();
        List<UserName> names = UserInput.inputUserNames();
//        String inputs[] = names.split(",");

        String result = UserInput.inputResult();
        String results[] = result.split(",");
        int height = UserInput.inputHeight();

        Ladder ladder = new Ladder();
        ladder.makeLines(names, height);

        View.showNames(names);
        View.showLadder(ladder);
        View.showLadderResult(results);
        //todo : matching  name : result


        String name = UserInput.wantToSeeName();
        View.showResult(name);
    }
}
