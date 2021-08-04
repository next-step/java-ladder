package nextstep.ladder;

import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String persons = inputView.initPerson();
        LadderName ladderName = new LadderName(persons);

        int maxLadderHeight = inputView.maxLadderHeight();

        resultView.printName(ladderName);

        //TODO: 해결
        List<String> people = HumanMaker.of(persons);
        resultView.println(maxLadderHeight, people);
    }
}
