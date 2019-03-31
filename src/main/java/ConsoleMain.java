import domain.LadderGame;
import domain.RandomNumberPointLottery;
import view.ConsoleInputView;
import view.ConsoleOutputView;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        List<String> userNames = ConsoleInputView.inputUserNames();
        Integer ladderHeight = ConsoleInputView.inputLadderHeight();

        LadderGame ladderGame = new LadderGame(userNames, ladderHeight, new RandomNumberPointLottery());
        ConsoleOutputView.printResult(ladderGame);
    }
}
