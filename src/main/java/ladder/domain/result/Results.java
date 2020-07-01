package ladder.domain.result;

import ladder.domain.play.Player;
import ladder.domain.play.Prize;

import java.util.Map;
import java.util.stream.Collectors;

public class Results {
    public static final int PRINT_ONE_LINE_SIZE = 1;

    private Map<Player, Prize> results;

    private Results(Map<Player, Prize> results) {
        this.results = results;
    }

    public static Results of(Map<Player, Prize> results) {
        return new Results(results);
    }

    public boolean printOneLine() {
        return results.size() == PRINT_ONE_LINE_SIZE;
    }

    @Override
    public String toString() {
        if (printOneLine()) {
            return results.entrySet().stream()
                    .map(itemItemEntry -> itemItemEntry.getValue().getInput())
                    .collect(Collectors.joining());
        }

        return results.entrySet().stream()
                .map(itemItemEntry -> itemItemEntry.getKey().getInput() + " : " + itemItemEntry.getValue().getInput())
                .collect(Collectors.joining("\n"));
    }
}
