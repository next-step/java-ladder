package ladder.domain.prize;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PrizesGeneratorTest {
    @Test
    void generate() {
        // given
        final String prizesExpression = "꽝,5000,꽝,3000";

        // when
        final Prizes prizes = PrizesGenerator.generate(prizesExpression);

        // then
        assertThat(prizes).isNotNull();
    }
}
