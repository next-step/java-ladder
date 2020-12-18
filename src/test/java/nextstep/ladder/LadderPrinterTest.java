package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import nextstep.ladder.domain.laddergenerator.DefaultGenerator;
import org.junit.jupiter.api.Test;

public class LadderPrinterTest {

    @Test
    public void test() {
        Members members = Members.of("one", "two", "three", "four");
        Height height = new Height(5);
        Ladder ladder = new Ladder(members, height);
        ladder.generateLadderWith(new DefaultGenerator());

        LadderPrinter.print(ladder);
    }
}
