package nextstep.ladder;

import nextstep.ladder.factory.LadderFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RandomLadderFactoryTest {

    @Test
    void 앞죄표가_true일_경우() {
        LadderFactory randomLadderFactory = new LadderFactory();
        boolean result = randomLadderFactory.addPoint(3, Arrays.asList(true, false, true));
        Assertions.assertThat(result).isFalse();
    }
}
