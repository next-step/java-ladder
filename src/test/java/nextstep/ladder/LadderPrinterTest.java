package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.floor.RandomFloorFactory;
import nextstep.ladder.ui.LadderPrinter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LadderPrinterTest {

    @Test
    public void test() {
        Members members = Members.of(Arrays.asList("one", "two", "three", "four"));
        Results results = Results.of(Arrays.asList("꽝", "1000", "2000", "3000"));
        Height height = new Height(5);
        Ladder ladder = new Ladder(members, results, height);
        ladder.generateFloorsWith(new RandomFloorFactory());

        LadderPrinter.print(ladder);
    }
}
