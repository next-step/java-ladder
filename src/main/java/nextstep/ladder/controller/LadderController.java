package nextstep.ladder.controller;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.PlayerResults;
import nextstep.ladder.dto.LinesInformation;
import nextstep.ladder.factory.LadderFactory;
import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderController {

    private static final String ALL = "all";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();

        List<String> names = inputView.inputNames();
        List<String> result = inputView.inputResult();
        int height = inputView.inputHeight();
        LinesInformation linesInformation = new LinesInformation(names.size(), height);

        Lines lines = LinesFactory.createLines(linesInformation, () -> new Random().nextBoolean());

        Ladder ladder = LadderFactory.create(names, height, () -> new Random().nextBoolean());
        PlayerResults playerResults = new PlayerResults(ladder);
        LadderResult ladderResult = new LadderResult(playerResults, result);

        resultView.ladderResult(ladder, result);

        while (true) {
            String name = inputView.inputName();
            resultView.result(ladderResult, name);
            if (ALL.equals(name)) {
                break;
            }
        }
    }
}
