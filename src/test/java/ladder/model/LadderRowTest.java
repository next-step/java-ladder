package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderRowTest {
    @Test
    public void 사다리_가로_라인이_겹치는_경우_예외_발생() throws Exception {
        //given
        List<Boolean> overlapped = List.of(true, false, true, true);

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderRow(overlapped));
    }

    @Test
    public void 사다리_가로_라인이_안_겹치는_경우엔_잘_생성되어야_한다() throws Exception {
        //given
        List<Boolean> overlapped = List.of(false, false, true, false);

        //when, then
        assertThatCode(() -> new LadderRow(overlapped))
                .doesNotThrowAnyException();
    }
}