package laddergameplay;

import laddergameplay.domain.Ladder;
import laddergameplay.domain.People;
import laddergameplay.exception.CustomException;
import laddergameplay.view.InputView;
import laddergameplay.view.ResultView;

import java.util.List;

public class LadderGameMain {

    public static void main(String[] args){
        try {
            List<String> peopleString = InputView.inputPeople();
            int countOfPeople = peopleString.size();

            int heightOfLadder = InputView.inputHeightOfLadder();

            People people = new People(peopleString);
            Ladder ladder = new Ladder(countOfPeople, heightOfLadder);

            ResultView.showResult(people, ladder);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
