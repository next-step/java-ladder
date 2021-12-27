package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultMatcherTest {
    @Test
    void 유효한_Players_PlayResult_Prizes로_생성() {
        PlayResult playResult = new PlayResult();
        playResult.put(new Position(0), new Position(1));
        playResult.put(new Position(1), new Position(2));
        playResult.put(new Position(2), new Position(0));

        ResultMatcher resultMatcher = new ResultMatcher(new Players("pobi,crong,jk"), playResult, new Prizes("꽝,5000,꽝"));
        assertThat(resultMatcher.match("pobi")).isEqualTo(new Prize("5000"));
        assertThat(resultMatcher.match("crong")).isEqualTo(new Prize("꽝"));
        assertThat(resultMatcher.match("jk")).isEqualTo(new Prize("꽝"));
    }
    @Test
    void 입력_Players_PlayResult_Prizes의_크기가_같지않으면_예외발생() {
        PlayResult playResult = new PlayResult();

        assertThatThrownBy(() -> new ResultMatcher(new Players("pobi,crong,jk"), playResult, new Prizes("꽝,5000,꽝")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ResultMatcher.WRONG_PARAMETER_VALUE_MESSAGE);
    }
}
