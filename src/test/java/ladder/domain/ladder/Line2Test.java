package ladder.domain.ladder;

import ladder.domain.ladder.generator.DirectionGenerator;
import ladder.domain.ladder.generator.StayDirectionGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Line2Test {
    private static final Logger log = LoggerFactory.getLogger(Line2Test.class);

    @Test
    public void 생성_시_갯수가_음수일_경우_IllegalArgumentException() {
        // when
        // then
        DirectionGenerator directionGenerator = new StayDirectionGenerator();
        assertThatIllegalArgumentException().isThrownBy(() -> Line2.init(-1, directionGenerator));
    }

    @Test
    public void 정상_생성() {
        // given
        int initialSize = 3;
        DirectionGenerator directionGenerator = new StayDirectionGenerator();
        Line2 line = Line2.init(initialSize, directionGenerator);

        // when
        int size = line.getSize();

        // then
        assertThat(size).isEqualTo(initialSize);

        log.debug("line\n{}", line);
    }
}
