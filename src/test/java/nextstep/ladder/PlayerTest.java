package nextstep.ladder;

import nextstep.ladder.domain.Player;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @ParameterizedTest
    @CsvSource({"김일치,true", "김불일치,false"})
    void isMatchedName_참여자의_이름과_일치하는지_여부를_판단한다(String name, boolean expected) {
        Player player = new Player("김일치");

        assertThat(player.isMatchedName(name)).isEqualTo(expected);
    }
}
