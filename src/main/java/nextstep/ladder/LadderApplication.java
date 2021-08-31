package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import static nextstep.ladder.util.Validation.*;

public class LadderApplication {
    public static void main(String[] args) {
        String inputPlayers = InputView.inputPlayers();
        Players players = new Players(inputPlayers);
        Result result = new Result(InputView.inputResult());
        isValidResult(players, result);
        int ladderHeight = InputView.inputLadderCount();
        Ladder ladder = new Ladder(players.size(), ladderHeight);
        ResultView.printLadderGame(players, ladder);
        ResultView.printResultGroup(result);
        while (true) {
            String gameResult = InputView.inputGameResultSearch();
            int playersNumber = isContainPlayer(gameResult, players);
            if (playersNumber == INPUT_ALL) {
                ResultView.printAllResult(players, ladder, result);
                break;
            }
            int index = ladder.search(playersNumber);
            ResultView.printPlayerResult(result.get(index));
        }
    }
}
