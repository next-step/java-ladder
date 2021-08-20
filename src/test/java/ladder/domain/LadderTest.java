package ladder.domain;

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
    static void setUp(){
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        List<Line> lines = Arrays.asList(
                new Line(Arrays.asList(true, false, false,false)),
                new Line(Arrays.asList(false, true, false,false)),
                new Line(Arrays.asList(false, false, true,false))
        );
        List<String> results = Arrays.asList("1","2","3","4","5");
        ladder = new Ladder(names, lines, results);
    }

    @DisplayName("플레이어 수와 사다리 높이 확인")
    @Test
    void create() {
        assertThat(ladder.getPlayers().size()).isEqualTo(5);
        assertThat(ladder.getLines().size()).isEqualTo(3);

        System.out.println(ladder.toString());
    }

    @Test
    void result(){
        String result = ladder.matchedResult("aa");
        assertThat(result).isEqualTo("4");

        OutputView outputView = new OutputView();
        outputView.printResult(ladder);
        System.out.println(result);
    }

}