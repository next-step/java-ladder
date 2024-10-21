package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    void create() {
        LadderLine ladderLine = LadderLine.of(9);

        assertThat(ladderLine.copy().size()).isEqualTo(8);
    }

    @ParameterizedTest
    @DisplayName("이전 결과 리스트를 받아 사다리 게임 한 층을 진행 시킨 결과 반영시킨다")
    @CsvSource(value = {
            "true,false,true,false,true:1,0,3,2,5,4",
            "true,false,false,true,false:1,0,2,4,3,5"
    }, delimiter = ':')
    void apply_ladder_play_result_to_list_parameter(String line, String result) {
        LadderLine ladderLine = new LadderLine(toList(line, Boolean::parseBoolean));
        List<Integer> indices = Arrays.asList(0, 1, 2, 3, 4, 5);

        ladderLine.play(indices);

        assertThat(indices).containsExactly(toList(result, Integer::parseInt).toArray(new Integer[0]));
    }

    private <T> List<T> toList(String string, Function<String, T> converter) {
        return Stream.of(string.split(","))
                .map(converter)
                .collect(Collectors.toList());
    }
}
