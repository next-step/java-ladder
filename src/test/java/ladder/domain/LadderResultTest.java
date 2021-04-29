package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderResultTest {
    @Test
    public void create() {
        final Name name = new Name("pobi");
        final Prize prize = new Prize("꽝");

        assertThatCode(() -> new LadderResult(name, prize))
                .doesNotThrowAnyException();
    }
}