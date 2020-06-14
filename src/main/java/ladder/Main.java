package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultVIew;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Players players = new Players(InputView.askingPeopleName());
        ResultGoods resultGoods = new ResultGoods(InputView.askingResult());

        List<String> playerNames = players.getPlayerNames();
        Ladder ladder = LadderFactory.createLadder(playerNames.size(), InputView.askingLadderMaxHeight());

        ResultVIew.printLadder(playerNames, ladder.getLines());
        ResultVIew.printResults(resultGoods.getResults());

        ResultRecord resultRecord = new ResultRecord();
        for (int idx = 0; idx < playerNames.size(); idx++) {
            resultRecord.add(new ResultOfPlayer(playerNames.get(idx), resultGoods.getResults().get(ladder.move(idx))));
        }

        String playerName = InputView.askingWantPlayerName();
        if ("all".equals(playerName)) {
            ResultVIew.printAllResultOfPlayer(resultRecord);
        } else {
            ResultVIew.printResultOfPlayer(resultRecord, playerName);
        }
    }
}
