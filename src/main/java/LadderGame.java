import domain.Ladder;
import domain.PlayerName;
import view.InputView;
import view.OutputView;
import view.ResultMapping;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        List<PlayerName> names = InputView.getInputNames().stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());

        List<String> results = InputView.getResults();
        int height = InputView.getLadderCount();

        Ladder ladder = new Ladder(names.size(), height);
        ResultMapping resultMapping = new ResultMapping(names, results);

        OutputView.printNames(names);
        OutputView.printLine(ladder);
        OutputView.printResults(results);

        while (true) {
            String input = InputView.askPlayer();
            if (input.equalsIgnoreCase("all")) {
                OutputView.printAllResults(names, ladder, resultMapping);
                break;
            } else {
                PlayerName player = new PlayerName(input);
                OutputView.printSingleResult(player, names, ladder, resultMapping);
            }
        }
    }
}
