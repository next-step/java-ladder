package nextstep.ladder.step2;

import nextstep.ladder.step2.domain.Ladder;
import nextstep.ladder.step2.domain.Line;
import nextstep.ladder.step2.domain.Player;
import nextstep.ladder.step2.view.ResultView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("참여자의 수에 맞는 사다리 라인 생성")
    void create() {
        Line point = new Line();
        point.createLine(5);
        assertThat(point.getPointSize()).isEqualTo(5);
    }

    @Test
    @DisplayName("이전에 가로 줄이 있으면 현재 가로 줄은 없어야 한다.")
    void checkPreviousPoint() {
        Line point = new Line();
        assertThat(point.checkPreviousPoint(true)).isFalse();
    }
}