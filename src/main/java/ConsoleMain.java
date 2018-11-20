import generator.AutoLadderGenerator;
import generator.LadderGenerator;
import model.Ladder;
import model.Positive;
import model.Result;
import view.InputView;
import view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        String participants = InputView.getParticipants();
        String results = InputView.getResults();
        Positive maxHight = InputView.getMaxHight();
        Ladder ladder = new Ladder(participants, maxHight, new AutoLadderGenerator());
        ResultView.printResult(ladder.getParticipants(), ladder.getLines(), Result.getResults(results));
        for (int i = 0; i < 2; i++) {
            ResultView.printExecuteResult(InputView.getResultView(), ladder.getParticipants(), ladder.getLines(), Result.getResults(results));
        }
    }
}
