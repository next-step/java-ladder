package ladder.domain.ladder;

import ladder.domain.user.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @ParameterizedTest
    @DisplayName("사다리 객체 생성 - 입력된 height 만큼 라인 객체를 갖고있음")
    @CsvSource(value = {"3,4,5"})
    void create(int height) {
        Players players = new Players(Arrays.asList("pobi", "honux"));
        Ladder ladder = Ladder.createLadder(players, new Height(height));
        assertThat(ladder.getLines()).size().isEqualTo(height);
    }

}
