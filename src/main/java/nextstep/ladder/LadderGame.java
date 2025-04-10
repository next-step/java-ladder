package nextstep.ladder;

import nextstep.ladder.parser.StringParser;
import nextstep.ladder.player.Entries;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        String[] nameArray = StringParser.parse(names);
        Entries players = new Entries(nameArray);

        String resultString = InputView.inputResult();
        String[] resultArray = StringParser.parse(resultString);
        Entries results = new Entries(resultArray);

        Height height = new Height(InputView.inputLadderHeight());
        Ladder ladder = new Ladder(height, players);
        ResultView.printResults(ladder);
    }
}
