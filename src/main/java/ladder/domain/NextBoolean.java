package ladder.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class NextBoolean implements NextBooleanRule{

    private static final List<Boolean> NEXT_BOOLEAN = new LinkedList<>();
    private static final int FIRST_INDEX = 0;

    static {
        NEXT_BOOLEAN.add(TRUE);
        NEXT_BOOLEAN.add(FALSE);
    }

    @Override
    public boolean movementRule() {
        Collections.shuffle(NEXT_BOOLEAN);
        return NEXT_BOOLEAN.get(FIRST_INDEX);
    }
}
