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
        Players players = Players.of(nameArray);

        String resultString = InputView.inputResult();
        String[] resultArray = StringParser.parse(resultString);

        Location height = new Location(InputView.inputLadderHeight());
        Lines lines = new Lines(height, players.size());

        Results results = Results.of(resultArray, height);

        ResultView.printLadder(players, lines, results);

        players.move(lines);

        Map<Entry, Entry> resultsMap = results.getResults(players);
        printResults(resultsMap, players);
    }

    private static void printResults(Map<Entry, Entry> resultsMap, Players players) {
        while (true) {
            String resultName = InputView.inputResultName();

            if (EXIT.equals(resultName)) {
                break;
            }

            if (ALL.equals(resultName)) {
                ResultView.printResults(resultsMap);
                continue;
            }

            if (players.notContains(resultName)) {
                ResultView.invalidName();
                continue;
            }

            Entry player = players.get(resultName);
            Entry result = resultsMap.get(player);
            ResultView.printResult(result);
        }
    }
}
