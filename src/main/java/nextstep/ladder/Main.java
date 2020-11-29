package nextstep.ladder;

import nextstep.ladder.domain.ConnectionCreationStrategyImpl;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Players players = Players.from(InputView.getNames());
        int height = InputView.getHeight();
        
        Lines lines = Lines.fromHeight(players.getSize() - 1, height, new ConnectionCreationStrategyImpl());
        
        OutputView.showPlayers(players);
        OutputView.showLines(lines);
    }
}
