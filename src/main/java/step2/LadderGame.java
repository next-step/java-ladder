package step2;

import step2.model.Ladder;
import step2.model.Person;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<Person> participants = new ArrayList<>();
        String[] nameList = InputView.askNameForLadderGame();
        for (String name : nameList) {
            participants.add(new Person(name));
        }
        int height = InputView.askHeightForLadderGame();
        Ladder ladder = new Ladder(height, participants.size());
        OutputView.printAll(participants, ladder);
    }
}
