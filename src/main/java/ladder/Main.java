package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultVIew;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Players players = new Players(InputView.askingPeopleName());
        ResultGoods resultGoods = new ResultGoods(InputView.askingResult());
        int ladderHeight = InputView.askingLadderMaxHeight();

        List<String> playerNames = players.getPlayerNames();
        Ladder ladder = Creator.createLadder(playerNames.size(), ladderHeight);

        ResultVIew.printLadder(playerNames, ladder.getLines());
        ResultVIew.printResults(resultGoods.getResults());

        List<ResultOfPlayer> resultOfPlayers = new ArrayList<>();
        for (int idx = 0; idx < playerNames.size(); idx++) {
            int result = ladder.move(idx);
            resultOfPlayers.add(new ResultOfPlayer(playerNames.get(idx), resultGoods.getResults().get(result)));
        }

        ResultVIew.printResultOfPlayer(resultOfPlayers, InputView.askingWantPlayerName());
        ResultVIew.printResultOfPlayer(resultOfPlayers, InputView.askingWantPlayerName());
    }
}
