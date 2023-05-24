package ladder;

import ladder.domain.result.GameResult;
import ladder.domain.Ladder;
import ladder.domain.result.LadderResult;
import ladder.domain.name.Name;
import ladder.domain.name.Names;
import ladder.domain.moving.FlowMoving;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        playLadderGameUntilException();
    }

    private static void playLadderGameUntilException() {
        while(isGameThrowException()){}
    }

    private static boolean isGameThrowException() {
        try {
            playLadderGame();
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private static void playLadderGame() throws IllegalArgumentException {
        InputView.askNames();
        String input = InputView.nextString();
        Names names = Names.of(input);

        InputView.askLadderResult();
        input = InputView.nextString();
        LadderResult ladderResults = LadderResult.of(input);

        InputView.askHeight();
        int height = InputView.nextInt();
        Ladder ladder = Ladder.of(height, names.count() - 1);
        GameResult gameResult = GameResult.of(FlowMoving.instance(), names, ladder);

        int width = names.properWidth();

        OutputView.printResult();
        OutputView.printLadderResult();
        OutputView.printNames(names, width);
        OutputView.printLadder(ladder, width * 2);
        OutputView.printLadderResult(ladderResults, width);

        printGameResult(names, ladderResults, gameResult);
    }

    private static void printGameResult(Names names, LadderResult ladderResults, GameResult gameResult) {
        OutputView.printGameResultOf();
        String name = InputView.nextString();
        while (!name.equals("all")) {
            OutputView.printGameResultOf(gameResult, ladderResults, Name.of(name));
            OutputView.printGameResultOf();
            name = InputView.nextString();
        }
        OutputView.printGameResultOfAll(gameResult, ladderResults, names);
    }

}
