package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("라인 없이 사다리 생성시 예외를 던진다.")
    void exception_creation(){
        assertThatThrownBy(()->{
            new Ladder(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성 테스트")
    void ladder_creation(){
        Ladder ladder = Ladder.of(2, 3, (num)->true);

        List<Line> res = new ArrayList<>();
        res.add(new Line(List.of(false, true, false, true, false)));
        res.add(new Line(List.of(false, true, false, true, false)));

        assertThat(ladder.getLineList())
                .isEqualTo(res);
    }
}