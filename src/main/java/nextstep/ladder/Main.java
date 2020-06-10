package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.factory.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class Main {

    private static final PlayerName ALL = PlayerName.newInstance("all");

    public static void main(String[] args) {
        Players players = InputView.getPlayers();
        Rewards rewards = InputView.getResults(players.getCount());
        Height height = InputView.getHeight();

        Ladder ladder = LadderFactory.create(players, height);
        ResultView.printLadder(ladder);
        ResultView.printRewards(rewards);

        Result result = ladder.run(rewards);

        while (true) {
            PlayerName playerName = InputView.getPlayerName();
            if (ALL.equals(playerName)) {
                break;
            }

            ResultView.printPlayerResult(players.findByName(playerName), result);
        }

        ResultView.printAllPlayerResult(result);
    }
}
