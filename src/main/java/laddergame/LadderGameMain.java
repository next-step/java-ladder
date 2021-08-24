package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.People;
import laddergame.exception.CustomException;
import laddergame.view.InputView;
import laddergame.view.ResultView;

import java.util.List;

public class LadderGameMain {

    public static void main(String[] args){
        try {
            List<String> peopleString = InputView.inputPeople();

            int heightOfLadder = InputView.inputHeightOfLadder();

            People people = new People(peopleString);
            Ladder ladder = new Ladder(people.size(), heightOfLadder);

            ResultView.showResult(people, ladder);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
