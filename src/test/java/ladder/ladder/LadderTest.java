package ladder.ladder;

import ladder.model.ladder.Ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    @Test
    public void 음수_높이_사다리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of("-1", 2));
    }

    @Test
    public void 높이가_없는_사다리() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Ladder.of("0", 2));
    }

    @Test
    public void 정상_사다리() {
        Ladder ladder = Ladder.of("1", 2);
        assertThat(ladder.getLadder().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("userNamesParams")
    public void 결과_반환(List<String> userNames){
        Ladder ladder = Ladder.of("1", 2);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladder.getResults(userNames));
    }

    private static Stream<Arguments> userNamesParams() {
        return Stream.of(
                Arguments.of(Arrays.asList("a","b","c")),
                Arguments.of(Collections.singletonList("a"))

        );
    }
}
