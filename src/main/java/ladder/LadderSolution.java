package ladder;

import ladder.domain.*;
import ladder.domain.line.LadderLine;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.line.RandomDirectionCreateStrategy;
import ladder.dto.request.PrintResultRequest;
import ladder.dto.response.LadderResult;
import ladder.view.DosInputView;
import ladder.view.DosResultView;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LadderSolution {
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
            List<Prize> prizes = inputPrizes();

            LadderResult ladderResult = ladder.result(players, prizes);

            PrintResultRequest resultRequest = new PrintResultRequest(
                    ladder, prizes, players
            );
            resultView.printResult(resultRequest);

            displayPrizes(ladderResult, players);
        } catch (Exception e) {
            resultView.printException(e);
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

    private List<Prize> inputPrizes() {
        return inputView.inputPrizeNames().stream()
                .map(Name::new)
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    private Ladder inputLadder(int playerSize) {
        int lineHeight = inputView.inputLineHeight();

        return newLadder(lineHeight, playerSize);
    }

    private Ladder newLadder(int lineHeight, int pointSize) {
        return Stream.generate(() -> newLadderLine(pointSize))
                .limit(lineHeight)
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(), Ladder::new
                        )
                );
    }

    private LadderLine newLadderLine(int pointSize) {
        return LadderLine.builder()
                .auto(new RandomDirectionCreateStrategy())
                .pointSize(pointSize)
                .build();
    }

    private void displayPrizes(LadderResult ladderResult, Players players) {
        String inputPlayerName;
        do {
            inputPlayerName = inputView.inputPrizeOwnerName();

            players.findByName(new Name(inputPlayerName))
                    .ifPresent(iPlayer ->
                            resultView.printPrizeOwner(ladderResult, iPlayer)
                    );
        } while(!inputPlayerName.equals("all"));
        resultView.printPrizeAll(ladderResult, players);
    }
}
