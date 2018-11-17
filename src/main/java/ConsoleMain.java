import generator.LineGenerator;
import model.Ladder;
import view.InputView;
import view.ResultView;

public class ConsoleMain {
    public static void main(String[] args) {
        String participants = InputView.getParticipants();
        String maxHight = InputView.getMaxHight();
        Ladder ladder = new Ladder(participants, maxHight, new LineGenerator());
        ResultView.printResult(ladder.getParticipants(), ladder.getLines());
    }
}
