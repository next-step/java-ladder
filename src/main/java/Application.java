import domain.Ladder;
import utility.UserInput;
import view.View;

public class Application {
    public static void main(String[] args) {
        String names = UserInput.inputUserNamse();
        String inputs[] = names.split(",");

        int height = UserInput.inputHeight();

        Ladder ladder = new Ladder();
        ladder.makeLines(inputs,height);

        View.showNames(inputs);
        View.showLadder(ladder);


    }
}
