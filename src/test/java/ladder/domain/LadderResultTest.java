package ladder.domain;

import java.util.Arrays;

public class LadderResultTest {
    public static final LadderResult LADDER_RESULT_PERSON2 = LadderResult.getInstance(Arrays.asList(ResultValueTest.RESULT_VALUE_FAIL, ResultValueTest.RESULT_VALUE_5000));
    public static final LadderResult LADDER_RESULT_PERSON_5 = LadderResult.getInstance(new String[] {"꽝","5000","200","꽝","40"});
}
