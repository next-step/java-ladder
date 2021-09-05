package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
public class LineTest {

    @Test
    void 라인은_겹치면_오류발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> Line.of(Arrays.asList(false, true, true, false))
                ).withMessageContaining("라인은 겹치면 안됩니다.");
    }

    @Test
    void 왼쪽_디딤대가_있을경우_디딤대를_타고_이동() {
        // given
        Line line = Line.of(Arrays.asList(false, true, false, true));

        // when
        int nowPosition = line.move(1);

        // then
        assertThat(nowPosition).isEqualTo(0);
    }

    @Test
    void 오른쪽_디딤대가_있을경우_디딤대를_타고_이동() {
        // given
        Line line = Line.of(Arrays.asList(false, true, false, true));

        // when
        int nowPosition = line.move(2);

        // then
        assertThat(nowPosition).isEqualTo(3);
    }

    @Test
    void 디딤대가_양쪽에_없을경우_아래칸으로_이동() {
        // given
        Line line = Line.of(Arrays.asList(false, false, false, true));

        // when
        int nowPosition = line.move(1);

        // then
        assertThat(nowPosition).isEqualTo(1);
    }

}
