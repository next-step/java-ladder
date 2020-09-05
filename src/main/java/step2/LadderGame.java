package step2;

import step2.model.Person;
import step2.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    public static void main(String[] args) {
        List<Person> Participants = new ArrayList<>();
        String[] nameList = InputView.askNameForLadderGame();
    }
}
