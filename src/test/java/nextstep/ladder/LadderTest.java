package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LadderTest {


    @Test
    public void 입력한높이만큼_라인을_생성한다() {
        List<Boolean> booleans = List.of(true, false);
        Ladder ladder = new Ladder(2, new NonConsecutiveFlagGenerator() {
            @Override
            protected List<Boolean> createResult() {
                return booleans;
            }
        });
        assertThat(ladder).isEqualTo(new Ladder(List.of(new Lines(booleans), new Lines(booleans))));
    }
}
