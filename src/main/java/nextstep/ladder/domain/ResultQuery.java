package nextstep.ladder.domain;

import java.util.function.Consumer;
import java.util.function.Supplier;
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

    static void queryUntilDone(LadderGameResult result,
                               Supplier<String> inputSupplier,
                               Consumer<String> output) {
        ResultQuery query = of(inputSupplier.get());
        while (query.execute(result, output)) {
            query = of(inputSupplier.get());
        }
    }
}