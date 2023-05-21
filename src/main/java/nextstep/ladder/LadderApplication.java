package nextstep.ladder;

import nextstep.ladder.domain.ExecutionResult;
import nextstep.ladder.domain.Gamers;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.RandomConnector;
import nextstep.ladder.dto.ExecutionResultDto;
import nextstep.ladder.dto.GamersDto;
import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<String> names = InputView.inputNames();
        Gamers gamers = Gamers.from(names);
        List<String> executionResult = InputView.inputExecutionResult();

        int height = InputView.inputLadderHeight();
        Ladder ladder = Ladder.ofHeightAndCountOfPerson(height, gamers.size(), new RandomConnector());

        ResultView.printGamers(GamersDto.from(gamers));
        ResultView.printLadder(LadderDto.from(ladder));
        ResultView.printResult(executionResult);

        Gamers climbedGamers = gamers.climb(ladder);
        ExecutionResult result = climbedGamers.matchResult(executionResult);
        String target = InputView.inputResultTarget();
        ResultView.printResultTarget(ExecutionResultDto.from(result), target);
    }
}
