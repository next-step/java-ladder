package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int height = inputView.getHeight();
        int countOfPeople = inputView.getCountOfPerson();

        Ladder ladder = new Ladder(height, countOfPeople);

        List<String> participants = inputView.getParticipants();
        ResultView resultView = new ResultView(participants);
        resultView.print(ladder);
    }
}
