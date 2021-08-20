package ladder.domain;

import ladder.dto.ResultDto;
import ladder.view.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static Ladder ladder;

    @BeforeAll
    static void setUp() {
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        List<Line> lines = Arrays.asList(
                new Line(Arrays.asList(true, false, false, true)),
                new Line(Arrays.asList(false, true, false, false)),
                new Line(Arrays.asList(true, false, true, false)),
                new Line(Arrays.asList(true, false, false, true))
        );
        List<String> results = Arrays.asList("1", "2", "3", "4", "5");
        ladder = new Ladder(names, lines, results);
    }

    @DisplayName("플레이어 수와 사다리 높이 확인")
    @Test
    void create() {
        System.out.println(ladder.toString());

        assertThat(ladder.getPlayers().size()).isEqualTo(5);
        assertThat(ladder.getLines().size()).isEqualTo(4);
    }

    @DisplayName("플레이어 한명의 결과 확인")
    @Test
    void result_one() {
        String result = ladder.matchedResult("aa");

        OutputView outputView = new OutputView();
        outputView.printResult(ladder, "aa");
        System.out.println(result);

        assertThat(result).isEqualTo("5");
    }

    @DisplayName("모든 플레이어의 결과 확인")
    @Test
    void result_all() {
        List<ResultDto> actual = ladder.matchedAllResult();
        List<ResultDto> expected = Arrays.asList(
                new ResultDto("aa", "5"),
                new ResultDto("bb", "1"),
                new ResultDto("cc", "2"),
                new ResultDto("dd", "4"),
                new ResultDto("ee", "3")
        );
        OutputView outputView = new OutputView();
        outputView.printResult(ladder, "all");
        System.out.println(actual.toString());

        assertThat(actual).isEqualTo(expected);
    }

}