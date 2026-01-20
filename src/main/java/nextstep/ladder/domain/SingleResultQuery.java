package nextstep.ladder.domain;

import java.util.function.Consumer;
import nextstep.ladder.LadderGameResult;

public class SingleResultQuery implements ResultQuery {
    private final String name;

    public SingleResultQuery(String name) {
        this.name = name;
    }

    @Override
    public boolean execute(LadderGameResult result, Consumer<String> output) {
        output.accept(result.getResult(name));
        return true;
    }
}