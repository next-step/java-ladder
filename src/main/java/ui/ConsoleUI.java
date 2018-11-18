package ui;

import domain.Ladder;
import domain.Player;
import domain.PlayerGroup;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

import java.util.List;

public class ConsoleUI {

    public static void main(String[] args) {
        String names = InputView.inputNames();
        List<Player> players = StringUtils.joinPlayer(StringUtils.splitDelemeter(names));
        PlayerGroup playerGroup = new PlayerGroup(players);

        String result = InputView.inputResult();
        List<Player> results = StringUtils.joinPlayer(StringUtils.splitDelemeter(result));
        PlayerGroup resultGroup = new PlayerGroup(results);

        int ladderHeight = InputView.inputLadderMaxHeight();

        Ladder ladder = Ladder.ofCount(ladderHeight, players.size());

        ResultView.resultStart();
        ResultView.printNames(players);
        ResultView.printLadder(ladder);
        ResultView.printNames(results);

        ResultView.printFinalResult(playerGroup, resultGroup, ladder);
    }




}
