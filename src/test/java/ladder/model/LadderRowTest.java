package ladder.model;

import ladder.model.ladder.LadderRow;
import ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    public void 설정한_width_만큼_생성되어야_한다() throws Exception {
        //given
        int width = 5;
        LadderRow row = LadderRow.create(width, new RandomStrategy());

        //when, then
        assertThat(row.size()).isEqualTo(width);
    }

    @Test
    public void 사다리_칸_존재여부를_확인할_수_있다() throws Exception {
        //given
        LadderRow row = new LadderRow(List.of(false, false, true, false));

        //when, then
        assertThat(row.exists(0)).isFalse();
        assertThat(row.exists(1)).isFalse();
        assertThat(row.exists(2)).isTrue();
        assertThat(row.exists(3)).isFalse();

    }
}