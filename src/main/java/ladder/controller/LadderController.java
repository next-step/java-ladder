package ladder.controller;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    public static void start() {

        List<String> stringNames = InputView.inputPerson();
        LadderResult ladderResult2 = LadderResult.of(InputView.inputResults());
        List<Name> names = stringNames.stream()
                .map(name -> Name.of(name))
                .collect(Collectors.toList());

        int height = InputView.inputHeight();
        Ladder ladder = Ladder.of(height, stringNames.size());

        FinalResult finalResult = FinalResult.of(ladder, ladderResult2, stringNames);
        ResultView.printName(names);
        ResultView.drawLadders(ladder, ladderResult2);
        ResultView.resultFinal(finalResult, InputView.inputFinalResult());
    }
}
