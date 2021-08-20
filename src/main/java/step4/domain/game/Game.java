package step4.domain.game;

import step4.domain.ladder.Ladder;
import step4.domain.ladder.LadderData;
import step4.domain.ladder.Result;
import step4.inputView.InputView;
import step4.outputView.OutputView;

import java.util.List;

public class Game {
    private final Ladder ladder;

    private final Result result;

    private Game(Ladder ladder, Result result) {
        this.ladder = ladder;
        this.result = result;
    }

    public static Game initGame() {
        LadderData ladderData = getLadderData();
        Ladder ladder = ladderData.createLadder();
        Result result = makeResult();
        result.validateResultSize(ladder.getLadderWidth());
        return new Game(ladder, result);
    }

    private static LadderData getLadderData() {
        List<String> names = InputView.getNames();
        int height = InputView.getHeight();
        return LadderData.of(names, height);
    }

    private static Result makeResult() {
        List<String> results = InputView.getResults();
        return Result.of(results);
    }

    public void findResultOf(List<String> names) {
        OutputView.showResultTest();
        for (String name : names) {
            int position = ladder.findPositionOf(name);
            int resultPosition = move(position);
            String resultOf = result.findResultOf(resultPosition);
            OutputView.showResultOf(name, resultOf);
        }
    }

    public int move(int position) {
        return ladder.move(position);
    }

    public void showMap() {
        OutputView.showLadder(ladder);
    }

    public void findResultAll() {
        findResultOf(ladder.inlineParticipants());
    }
}
