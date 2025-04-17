package nextstep.ladder;

import nextstep.ladder.line.Lines;
import nextstep.ladder.parser.StringParser;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

import java.util.Map;

public class LadderGame {
    private static final String EXIT = "exit";
    private static final String ALL = "all";

    public static void main(String[] args) {
        String names = InputView.inputNames();
        String[] nameArray = StringParser.parse(names);
        Names players = Names.of(nameArray);

        String resultString = InputView.inputResult();
        String[] resultArray = StringParser.parse(resultString);

        Height height = new Height(InputView.inputLadderHeight());
        Lines lines = new Lines(height, players.size());

        Names results = Names.of(resultArray);

        ResultView.printLadder(players, lines, results);

        Map<Name, Name> resultsMap = lines.getResults(players, results);
        printResults(resultsMap, players);
    }

    private static void printResults(Map<Name, Name> resultsMap, Names players) {
        while (true) {
            String resultNameString = InputView.inputResultName();

            if (EXIT.equals(resultNameString)) {
                break;
            }

            if (ALL.equals(resultNameString)) {
                ResultView.printResults(resultsMap);
                continue;
            }

            Name resultName = new Name(resultNameString);

            if (players.notContains(resultName)) {
                ResultView.invalidName();
                continue;
            }

            Name result = resultsMap.get(resultName);
            ResultView.printResult(result);
        }
    }
}
