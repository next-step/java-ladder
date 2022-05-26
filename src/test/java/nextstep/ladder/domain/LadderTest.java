package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("라인 없이 사다리 생성시 예외를 던진다.")
    void exception_creation_null(){
        assertThatThrownBy(()->{
            new Ladder(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("empty list면 생성시 예외를 던진다.")
    void exception_creation_emptyList(){
        assertThatThrownBy(()->{
            new Ladder(Collections.emptyList());
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("사다리 생성 테스트")
    void ladder_creation(){
        Ladder ladder = Ladder.of(2, 3, ()->true);

        List<Line> res = new ArrayList<>();
        res.add(new Line(List.of(false, true, false, true, false)));
        res.add(new Line(List.of(false, true, false, true, false)));

        assertThat(ladder.getLines())
                .isEqualTo(res);
    }

    @Test
    void 결과_위치를_반환(){
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(false, true, false, true, false)),
                new Line(List.of(false, false, true, false, false)),
                new Line(List.of(false, true, false, true, false))
        ));

        assertThat(ladder.findResult(0)).isEqualTo(3);
        assertThat(ladder.findResult(1)).isEqualTo(1);
        assertThat(ladder.findResult(2)).isEqualTo(2);
        assertThat(ladder.findResult(3)).isEqualTo(0);
    }
}