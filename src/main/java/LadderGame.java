import domain.Ladder;
import domain.PlayerName;
import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        List<PlayerName> names = InputView.getInputNames().stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());

        Ladder ladder = new Ladder(names.size(), InputView.getLadderCount());

        OutputView.printNames(names);
        OutputView.printLine(ladder);
    }
}
