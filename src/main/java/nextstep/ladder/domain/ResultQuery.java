package nextstep.ladder.domain;

import java.util.function.Consumer;
import nextstep.ladder.LadderGameResult;

public interface ResultQuery {
    String ALL = "all";

    boolean execute(LadderGameResult result, Consumer<String> output);

    static ResultQuery of(String input) {
        if (ALL.equalsIgnoreCase(input)) {
            return new AllResultQuery();
        }
        return new SingleResultQuery(input);
    }
}