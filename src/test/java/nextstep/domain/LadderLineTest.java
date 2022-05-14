package nextstep.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LadderLineTest {
    @ParameterizedTest
    @ValueSource(booleans = {true,false})
    void 사다리라인_생성_유무_확인(boolean isLadderGenerate) {
        List<Boolean> result = new ArrayList<>();
        result.add(false);
        IntStream.range(0,5)
                .mapToObj(i -> result.add(isLadderGenerate))
                .collect(Collectors.toList());
        result.add(false);
        List<Boolean> input = new ArrayList<>();
        input.add(isLadderGenerate);
        assertThat(new LadderLine(input).getPoints()).isEqualTo(result);
    }

    @Test
    void 사다리라인생성기가_연속적으로_true더라도_사다리라인_겹치지_않는지_체크() {
        List<Boolean> result = List.of(false,true,true,true,true,true
                ,false,false,false,false,false,false,false);
        List<Boolean> input = List.of(true,true);
        assertThat(new LadderLine(input).getPoints()).isEqualTo(result);
    }

    @Test
    void 사다리살_잘타는지_확인() {
        List<Boolean> input = List.of(true,true);
        assertThat(new LadderLine(input).moveLadderLine(0)).isEqualTo(6);
    }

}