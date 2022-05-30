package ladder.controller;

import ladder.domain.FinalResult;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Name;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    public static void start() {
        List<String> stringNames = InputView.inputNames();
        LadderResult ladderResult = LadderResult.of(InputView.inputResults());
        List<Name> names = stringNames.stream()
                .map(name -> Name.of(name))
                .collect(Collectors.toList());

        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(height, stringNames.size());
        FinalResult finalResult = FinalResult.of(ladderResult.findLadderResult(ladder), stringNames);
        
        ResultView.printName(names);
        ResultView.drawLadders(ladder);
        ResultView.printResult(ladderResult);
        ResultView.resultFinal(finalResult, InputView.inputFinalResult());
    }
}
