package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.GameResultView;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        String participatorsName = inputView.inputParticipators();
        String results = inputView.inputLadderResults();

        Participators participators = Participators.from(makeStringList(participatorsName));
        LadderResults ladderResults = new LadderResults(makeStringList(results));

        if (!isParticipatorsAndResultHasSameCount(participators, ladderResults)) {
            throw new IllegalArgumentException("참가자 수와 사다리 결과의 개수가 다릅니다.");
        }

        int ladderHeight = inputView.inputLadderHeight();
        Ladder ladder = Ladder.makeLadder(participators.participatorCount(), ladderHeight);

        participators.playLadder(ladder);

        outputView.printLadderStatus(participators, ladder, ladderResults);

        GameResultView gameResultView = new GameResultView();

        while (true) {
            String name = inputView.inputResultName();
            String result = gameResultView.gameResult(participators, ladderResults, name);
            outputView.printResult(result);

            if (name.equals("all")) {
                break;
            }
        }
    }

    private static boolean isParticipatorsAndResultHasSameCount(Participators participators, LadderResults ladderResults) {
        return participators.participatorCount() == ladderResults.ladderResultCount();
    }

    private static List<String> makeStringList(String participators) {
        return Arrays.stream(participators.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
