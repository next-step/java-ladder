package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultVIew;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Players players = new Players(InputView.askingPeopleName());
        ResultGoods resultGoods = new ResultGoods(InputView.askingResult());
        int ladderHeight = InputView.askingLadderMaxHeight();

        List<String> peopleNames = players.getPlayerNames();
        LadderCreator ladderCreator = new LadderCreator(peopleNames.size(), ladderHeight);
        Ladder ladder = ladderCreator.createLadder();

        ResultVIew.printLadder(peopleNames, ladder.getLines());
        ResultVIew.printResults(resultGoods.getResults());

        LadderGame ladderGame = new LadderGame(players, resultGoods);
        List<ResultOfPlayer> resultOfPlayers = ladderGame.gameResult(ladder, peopleNames.size());

        ResultVIew.printResultOfPlayer(resultOfPlayers, InputView.askingWantPlayerName());
        ResultVIew.printResultOfPlayer(resultOfPlayers, InputView.askingWantPlayerName());
    }
}
