package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Names;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Names names = new Names(inputView.requestName());
        LadderResult ladderResult = new LadderResult(inputView.requestLadderResult());
        validateInput(names, ladderResult);
        int height = inputView.requestHeight();

        Ladder ladder = new Ladder(height, names.size(), () -> new Random().nextBoolean());

        ResultView resultView = new ResultView();
        resultView.printLadder(names, ladder, ladderResult);

        showResult(inputView, names, ladderResult, ladder, resultView);
    }

    private static void validateInput(Names names, LadderResult ladderResult) {
        if(names.size() != ladderResult.size()) {
            throw new IllegalArgumentException("이름의 수와 결과의 수가 다릅니다.");
        }
    }

    private static void showResult(InputView inputView, Names names, LadderResult ladderResult, Ladder ladder, ResultView resultView) {
        while (true) {
            String name = inputView.requestWhoseResult();
            if (name.equals("all")) {
                List<String> results = ladder.resultAll().stream()
                        .map(index -> ladderResult.get(index))
                        .collect(Collectors.toList());
                resultView.printResult(names, results);
            } else {
                int resultIndex = ladder.resultOf(names.indexOf(name));
                resultView.printResult(ladderResult.get(resultIndex));
            }
        }
    }
}
