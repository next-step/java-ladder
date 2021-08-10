package nextstep.ladder;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.stream.Collectors;
import nextstep.ladder.domain.LadderJackpot;
import nextstep.ladder.domain.LadderJackpots;
import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String initPerson = InputView.initPerson();
        String[] executionResult = LadderJackpots.of(Arrays.stream(initPerson.split(","))
            .map()
            .collect(collectingAndThen(toList(), LadderJackpot::of);

        int maxLadderHeight = InputView.maxLadderHeight();
        ResultView resultView = ResultView.getInstance();
        LadderNames ladderNames = LadderNames.of(initPerson);

        resultView.printLadderNames(ladderNames);
        resultView.printLadderLines(ladderNames.size(), maxLadderHeight);


        String name = InputView.resultName();

        int index = ladderNames.searchName(name);
    }
}
