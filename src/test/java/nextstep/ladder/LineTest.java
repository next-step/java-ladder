package nextstep.ladder;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void 선은_최소_한명이상이_있어야_만들어진다() {
        assertThatThrownBy(() -> new Line(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인은 1명 이상인 경우만 생성 됩니다");
    }

    @Test
    void 컬럼에서_오른쪽에_다리가_놓여있으면_오른쪽_한칸으로_이동한다() {
        Line line = new Line(List.of(false, true, false));
        assertThat(line.move(1)).isEqualTo(2);
    }

    @Test
    void 컬럼에서_왼쪽쪽에_다리가_놓여있으면_왼쪽_한칸으로_이동한다() {
        Line line = new Line(List.of(true, false, false));
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    void 컬럼에서_왼쪽_끝에_있는_경우_오른쪽에_다리가_있으면_이동한다() {
        Line line = new Line(List.of(true, false, false));
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void 컬럼에서_오른쪽_끝에_있는_경우_왼쪽에_다리가_있는경우_이동한다() {
        Line line = new Line(List.of(false, false, true));
        assertThat(line.move(3)).isEqualTo(2);
    }
}