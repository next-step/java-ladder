import domain.Ladder;
import view.InputView;
import view.OutputView;

public class LadderGame {
    public static void main(String[] args){
        String[] personNames = InputView.inputPersonNames();
        int height = InputView.inputLadderHeight();

        OutputView.printResult(new Ladder(personNames, height));
    }
}
