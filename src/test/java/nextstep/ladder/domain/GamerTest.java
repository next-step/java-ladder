package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GamerTest {

    @Test
    void of() {
        Gamer actual = Gamer.of("test", 1);
        Gamer expected = new Gamer(Name.from("test"), Position.from(1));

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void climb() {
        Gamer gamer = Gamer.of("test", 1);
        Gamer climbed = gamer.climb(LadderTest.getLadder());

        assertThat(climbed).isEqualTo(gamer);
    }

    @Test
    @DisplayName("사다리 결과들을 받고 매칭되는 결과를 반환")
    void match() {
        Gamer gamer = Gamer.of("test", 1);
        List<String> results = List.of("꽝", "당첨", "꽝", "꽝");
        Result actual = gamer.match(results);

        assertThat(actual).isEqualTo(Result.from("당첨"));
    }
}