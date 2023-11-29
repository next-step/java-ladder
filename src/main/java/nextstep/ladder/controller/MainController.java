package nextstep.ladder.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.LadderHeight;
import nextstep.ladder.model.Name;
import nextstep.ladder.model.PersonCount;
import nextstep.ladder.model.RandomTrueOrFalse;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class MainController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String namesText = inputView.inputUserNames();
        List<Name> names = Arrays.stream(namesText.split(","))
            .map(Name::new)
            .collect(Collectors.toList());

        PersonCount countOfPerson = new PersonCount(names.size());

        String heightOfLadderText = inputView.inputHeightOfLadder();
        LadderHeight heightOfLadder = new LadderHeight(Integer.parseInt(heightOfLadderText));

        Ladder ladder = new Ladder(heightOfLadder, countOfPerson, new RandomTrueOrFalse());

        OutputView outputView = new OutputView();
        outputView.print(ladder, names);
    }

}
