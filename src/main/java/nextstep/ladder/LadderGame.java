package nextstep.ladder;

import nextstep.ladder.line.Lines;
import nextstep.ladder.parser.StringParser;
import nextstep.ladder.player.Entries;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class LadderGame {
    public static void main(String[] args) {
        String names = InputView.inputNames();
        String[] nameArray = StringParser.parse(names);
        Entries players = Entries.of(nameArray);

        String resultString = InputView.inputResult();
        String[] resultArray = StringParser.parse(resultString);
        Entries results = Entries.of(resultArray);

        Height height = new Height(InputView.inputLadderHeight());
        Lines lines = new Lines(height, players.size());
        Ladder ladder = new Ladder(lines, players);
        ladder.play();

        ResultView.printLadder(ladder, results);
    }
}
