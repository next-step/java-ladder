package nextstep.ladder.domain;

import java.util.function.Consumer;
import nextstep.ladder.LadderGameResult;

public class AllResultQuery implements ResultQuery {

    @Override
    public boolean execute(LadderGameResult result, Consumer<String> output) {
        return false;
    }
}