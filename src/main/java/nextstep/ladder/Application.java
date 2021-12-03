package nextstep.ladder;

import nextstep.ladder.domain.*;
import nextstep.ladder.utils.StringUtils;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Players players = getPlayers();

        int playersCount = players.playersCount();
        int ladderHeight = InputView.askLadderHeight();

        LinesGenerator generator = new RandomLinesGenerator();

        Lines lines = generator.generate(playersCount, ladderHeight);

        Ladder ladder = Ladder.from(lines);

        OutputView.printLadder(players, ladder);
    }

    private static Players getPlayers() {
        String playerssName = InputView.askPlayerssName();
        String[] names = StringUtils.split(playerssName);
        try {
            return Players.from(names);
        } catch (IllegalArgumentException e) {
            OutputView.printPlayersCountError();
            return getPlayers();
        }
    }

}
