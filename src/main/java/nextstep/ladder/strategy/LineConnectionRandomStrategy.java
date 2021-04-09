package nextstep.ladder.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class LineConnectionRandomStrategy implements LineConnectionStrategy {

    private static final List<Boolean> CONNECT = Arrays.asList(true, false);

    @Override
    public boolean createLine(boolean previousLine) {
        if (previousLine) {
            return false;
        }
        Collections.shuffle(CONNECT);
        return CONNECT.get(0);
    }
}
