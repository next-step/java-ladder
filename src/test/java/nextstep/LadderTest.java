package nextstep;

import nextstep.domain.Ladder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void 사다리의_높이는_입력받은_높이와_같다() {

        Ladder ladder = Ladder.makeLadder(5, 3);

        assertThat(ladder.ladder()).hasSize(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 사다리_탄_후의_위치는_0이상_참가자_수_미만(int position) {

        // given
        Ladder ladder = Ladder.makeLadder(5, 4);

        // when
        int result = ladder.climb(position);

        // then
        assertThat(result).isGreaterThanOrEqualTo(0);
        assertThat(result).isLessThan(4);
    }
}
