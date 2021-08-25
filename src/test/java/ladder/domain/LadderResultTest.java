package ladder.domain;

import ladder.dto.ResultDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {
    private static Ladder ladder;
    private static LadderResult ladderResult;

    @BeforeAll
    static void setUp() {
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        List<Line> lines = Arrays.asList(
                Line.of(Arrays.asList(true, false, false, true)),
                Line.of(Arrays.asList(false, true, false, false)),
                Line.of(Arrays.asList(true, false, true, false)),
                Line.of(Arrays.asList(true, false, false, true))
        );
        List<String> results = Arrays.asList("1", "2", "3", "4", "5");
        ladder = new Ladder(lines);
        ladderResult = new LadderResult(names, results);
    }

    @DisplayName("플레이어 한명의 결과 확인")
    @Test
    void result_one() {
        String result = ladderResult.result("aa", ladder).getResult();
        assertThat(result).isEqualTo("5");
    }

    @DisplayName("없는 이름을 입력할 경우 에러")
    @Test
    void result_error() {
        assertThatThrownBy(() -> ladderResult.result("xx", ladder))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 플레이어의 결과 확인")
    @Test
    void result_all() {
        List<ResultDto> actual = ladderResult.results(ladder);
        List<ResultDto> expected = Arrays.asList(
                new ResultDto("aa", "5"),
                new ResultDto("bb", "1"),
                new ResultDto("cc", "2"),
                new ResultDto("dd", "4"),
                new ResultDto("ee", "3")
        );
        assertThat(actual).isEqualTo(expected);
    }
}