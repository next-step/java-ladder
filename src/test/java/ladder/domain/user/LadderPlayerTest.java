package ladder.domain.user;

import ladder.RandomTestUtils;
import ladder.common.Csv;
import ladder.common.PositiveNumber;
import ladder.domain.DefaultLadderLineFactory;
import ladder.domain.ladderline.LadderLines;
import ladder.view.result.DefaultResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPlayerTest {

    private LadderPlayer ladderPlayer;

    @BeforeEach
    void setup() {
        //  a     b     c     d     e
        //  |-----|     |-----|     |
        //  |-----|     |-----|     |
        //  |-----|     |-----|     |
        //  |-----|     |-----|     |
        //  |-----|     |-----|     |
        //  1     2     3     4     5
        LadderLines ladderLines = new DefaultLadderLineFactory(RandomTestUtils.TRUE).create(PositiveNumber.of(5), PositiveNumber.of(5));
        LadderUsers ladderUsers = LadderUsers.of(Arrays.asList("a", "b","c","d","e"));
        Csv ladderResult = Csv.ofString("1,2,3,4,5");

        ladderPlayer = LadderPlayer.of(ladderLines, ladderUsers, ladderResult);
    }

    @Test
    @DisplayName("첫번째 사용자의 결과를 확인한다")
    void checkResult1() {
        LadderResult ladderResult = ladderPlayer.start(Username.of("a"));

        assertThat(ladderResult.findAll().get(Username.of("a"))).isEqualTo("2");
    }

    @Test
    @DisplayName("두번째 사용자의 결과를 확인한다")
    void checkResult2() {
        LadderResult ladderResult = ladderPlayer.start(Username.of("b"));

        assertThat(ladderResult.findAll().get(Username.of("b"))).isEqualTo("1");
    }

    @Test
    @DisplayName("세번째 사용자의 결과를 확인한다")
    void checkResult3() {
        LadderResult ladderResult = ladderPlayer.start(Username.of("c"));

        assertThat(ladderResult.findAll().get(Username.of("c"))).isEqualTo("4");
    }

    @Test
    @DisplayName("네번째 사용자의 결과를 확인한다")
    void checkResult4() {
        LadderResult ladderResult = ladderPlayer.start(Username.of("d"));

        assertThat(ladderResult.findAll().get(Username.of("d"))).isEqualTo("3");
    }

    @Test
    @DisplayName("다섯번째 사용자의 결과를 확인한다")
    void checkResult5() {
        LadderResult ladderResult = ladderPlayer.start(Username.of("e"));

        assertThat(ladderResult.findAll().get(Username.of("e"))).isEqualTo("5");
    }
}
