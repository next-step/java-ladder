package ladder;

import ladder.domain.LadderLine;
import ladder.domain.Rope;
import ladder.exception.InvalidRopeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineTest {
    @ValueSource(strings = {
            "true,true,false",
            "true,true",
            "false,true,true,false",
            "false,false,true,true,false"
    })
    @ParameterizedTest
    public void 이어지는_로프_테스트(String strRopes) {
        List<Rope> ropes = Arrays.stream(strRopes.split(","))
                .map(Boolean::valueOf)
                .map(Rope::of)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new LadderLine(ropes))
                .isInstanceOf(InvalidRopeException.class);
    }

    @ValueSource(strings = {
            "true,false",
            "false,true,false,false",
            "false,false,true,false,true"
    })
    @ParameterizedTest
    public void 이어지는_로프_테스트_통과(String strRopes) {
        List<Rope> ropes = Arrays.stream(strRopes.split(","))
                .map(Boolean::valueOf)
                .map(Rope::of)
                .collect(Collectors.toList());

        assertThatCode(() -> new LadderLine(ropes))
                .doesNotThrowAnyException();
    }
}