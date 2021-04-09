package nextstep.ladder.service;

import nextstep.ladder.domain.Bar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {


    @DisplayName("Line 생성 테스트")
    @Test
    void create_라인_생성테스트() {
        // given
        Line line = Line.valueOf(Bar.init(), Bar.valueOf(true));
        // when
        Line expected = Line.valueOf(Bar.init(), Bar.valueOf(true));
        // then
        assertThat(line).isEqualTo(expected);
    }

    @DisplayName("Line 전략별 생성 테스트")
    @Test
    void create_랜덤_전략_테스트() {
        // given
        Line line = Line.valueOf(Bar.init(), Bar.valueOf(true));
        // when
        List<Bar> bars = line.points().bars();
        // then
        assertAll(
                () -> assertThat(bars.get(0).isExist()).isFalse(),
                () -> assertThat(bars.get(1).isExist()).isTrue()
        );
    }

    @DisplayName("Line의 Point 확인 테스트 참여자 2인: |-----|")
    @Test
    void check_point_값_확인_테스트() {
        // given
        Line line = Line.valueOf(Bar.init(), Bar.valueOf(true), Bar.init());
        // when
        Bar[] expected = {Bar.init(), Bar.valueOf(true), Bar.init()};
        // then
        assertThat(line.points().bars()).contains(expected);
    }

}
