package ladder;

import ladder.domain.Ladder;
import ladder.domain.Name;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.exception.DuplicateKeyException;
import ladder.exception.InvalidRopeException;
import ladder.exception.OutOfLengthException;
import ladder.view.DosInputView;
import ladder.view.DosResultView;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.stream.Collectors;

public class LadderSolution {
    public static void main(String[] args) {
        LadderSolution ladderSolution = new LadderSolution(
                new DosInputView(), new DosResultView()
        );
        ladderSolution.run();
    }

    private final InputView inputView;
    private final ResultView resultView;

    public LadderSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            Players players = inputPlayers();
            int lineHeight = inputView.inputLineHeight();

            Ladder ladder = Ladder.randomGenerate(players.size(), lineHeight);

            resultView.printResult(players, ladder);
        } catch (DuplicateKeyException | InvalidRopeException | OutOfLengthException e) {
            resultView.printException(e);
        } catch (Exception e) {
            resultView.printException(
                    new RuntimeException("오류가 발생 했습니다.")
            );
        }
    }

    private Players inputPlayers() {
        return inputView.inputPlayerNames().stream()
                .map(Name::new)
                .map(Player::new)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), Players::new
                ));
    }
}
