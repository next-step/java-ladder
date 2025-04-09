package nextstep.ladder;

import nextstep.ladder.parser.StringParser;
import nextstep.ladder.player.Players;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        String[] nameArray = StringParser.parse(names);
        Players players = new Players(nameArray);
        Height height = new Height(InputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, players);
        ResultView.printResults(ladder);
    }
}
