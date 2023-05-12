package ladder.model.ladder;

import ladder.strategy.RandomStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderRowTest {
    @Test
    public void 사다리_가로_연결이_겹치는_경우_예외_발생() throws Exception {
        assertThatIllegalStateException()
                .isThrownBy(() -> LadderRow.of(true, false, true, true));
    }

    @Test
    public void 사다리_가로_연결이_안_겹치는_경우엔_잘_생성되어야_한다() throws Exception {
        assertThatCode(() -> LadderRow.of(false, false, true, false))
                .doesNotThrowAnyException();
    }

    @Test
    public void 설정한_사다리_기둥_수_만큼_생성되어야_한다() throws Exception {
        //given
        int stiles = 5;
        LadderRow row = LadderRow.create(stiles, new RandomStrategy());

        //when, then
        assertThat(row.stiles().size()).isEqualTo(stiles);
        assertThat(row.width()).isEqualTo(stiles - 1); // 너비는 기둥 수 - 1 이다.

    }

    @Test
    public void 사다리_기둥_개수는_1보다_커야_한다() throws Exception {
        // exception
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderRow.create(1, new RandomStrategy()));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderRow.create(0, new RandomStrategy()));

        // ok
        assertThatCode(() -> LadderRow.of(false, false))
                .doesNotThrowAnyException();
    }

    @Test
    public void 사다리_연결에_따른_이동_후_결과를_제대로_구할_수_있다() throws Exception {
        //given
        LadderRow row = LadderRow.of(true, false); // |--|  |

        //when, then
        assertThat(row.nextStile(0)).isEqualTo(1);
        assertThat(row.nextStile(1)).isEqualTo(0);
        assertThat(row.nextStile(2)).isEqualTo(2);
    }
}