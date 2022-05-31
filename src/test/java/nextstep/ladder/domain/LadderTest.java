package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nextstep.ladder.domain.LineTest.convertToPoints;
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
        Ladder ladder = Ladder.of(2, 4, ()->true);

        List<Line> res = new ArrayList<>();
        res.add(new Line(convertToPoints(List.of(false, true, false, true, false))));
        res.add(new Line(convertToPoints(List.of(false, true, false, true, false))));

        assertThat(ladder.getLines())
                .isEqualTo(res);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 3",
            "1, 1",
            "2, 2",
            "3, 0"
    })
    void 결과_위치를_반환(int startIndex, int finalIndex){
        Ladder ladder = new Ladder(List.of(
                new Line(convertToPoints(List.of(false, true, false, true, false))),
                new Line(convertToPoints(List.of(false, false, true, false, false))),
                new Line(convertToPoints(List.of(false, true, false, true, false)))
        ));

        assertThat(ladder.findResult(startIndex)).isEqualTo(finalIndex);
    }
}