package ladder.fixture;

import java.util.Arrays;
import java.util.List;

public class LadderFixture {

    public static List<List<Boolean>> ladderRowFixture() {
        return Arrays.asList(
            Arrays.asList(true, false, true)
            , Arrays.asList(false, true, false)
            , Arrays.asList(true, false, false)
            , Arrays.asList(false, true, false)
            , Arrays.asList(true, false, true));
    }

}
