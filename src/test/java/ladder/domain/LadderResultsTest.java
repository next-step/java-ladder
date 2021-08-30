package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LadderResultsTest {

    @Test
    public void 문자열을_받아서_파싱_후_Results를_생성할_수_있디() {
        //given
        //when
        LadderResults ladderResults = LadderResults.create("5000,꽝,3000,2000");
        //then
        assertThat(ladderResults).isEqualTo(LadderResults.create("5000,꽝,3000,2000"));
    }
}
