package ladder;

import ladder.domain.*;
import ladder.dto.LadderRandomGenerateRequest;
import ladder.dto.LadderRequest;
import ladder.exception.DuplicateKeyException;
import ladder.exception.InvalidRopeException;
import ladder.exception.OutOfLengthException;
import ladder.view.DosInputView;
import ladder.view.DosResultView;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
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
            Ladder ladder = inputLadder(players.size());

            resultView.printResult(players, ladder);
        } catch (DuplicateKeyException | InvalidRopeException | OutOfLengthException e) {
            resultView.printException(e);
        }/* catch (Exception e) {
            resultView.printException(
                    new RuntimeException("오류가 발생 했습니다.")
            );
        }*/
    }

    private Players inputPlayers() {
        return inputView.inputPlayerNames().stream()
                .map(Name::new)
                .map(Player::new)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), Players::new
                ));
    }

    private Ladder inputLadder(int ropeSize) {
        LadderRequest ladderRequest = inputView.inputLadderRequest();

        List<Prize> prizes = ladderRequest.prizeNames().stream()
                .map(Name::new)
                .map(Prize::new)
                .collect(Collectors.toList());
        LadderRandomGenerateRequest ladderRandomGenerateRequest = new LadderRandomGenerateRequest(
                prizes, ropeSize, ladderRequest.lineHeight()
        );

        return Ladder.randomGenerate(ladderRandomGenerateRequest);
    }
}
