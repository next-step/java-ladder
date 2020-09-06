package step2;

import step2.model.Height;
import step2.model.Ladder;
import step2.model.Person;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    public static void main(String[] args) {
        String[] nameList = InputView.askNameForLadderGame();
        List<Person> participants = Arrays.stream(nameList)
                .map(Person::new)
                .collect(Collectors.toList());

        Height height = new Height(InputView.askHeightForLadderGame());
        //Ladder ladder = new Ladder(height, participants.size());
        //OutputView.printAll(participants, ladder);
    }
}
