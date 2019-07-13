package ladder.domain.user;

import ladder.RandomTestUtils;
import ladder.common.Csv;
import ladder.common.PositiveNumber;
import ladder.domain.DefaultLadderLineFactory;
import ladder.domain.ladderline.LadderLines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        LadderUsers ladderUsers = LadderUsers.of(Arrays.asList("a", "b", "c", "d", "e"));
        Csv ladderResult = Csv.ofString("1,2,3,4,5");

        ladderPlayer = LadderPlayer.of(ladderLines, ladderUsers, ladderResult);
    }

    @ParameterizedTest
    @DisplayName("각 출발점의 결과가 정상적인지 확인한다")
    @CsvSource({"a,2", "b,1", "c,4", "d,3", "e,5"})
    void checkLadderResult(String username, String result) {
        LadderResult ladderResult = ladderPlayer.start(Username.of(username));
        assertThat(ladderResult.findAll().get(Username.of(username))).isEqualTo(result);
    }
}
