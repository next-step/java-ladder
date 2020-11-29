package ladder.domain;

import ladder.domain.prize.Prizes;
import ladder.domain.prize.PrizesGenerator;
import ladder.domain.user.Users;
import ladder.domain.user.UsersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderGameTest {

    @DisplayName("정적 팩터리 메서드를 이용한 생성")
    @Test
    void of() {
        // given
        final int userCount = 4;
        final int ladderHeight = 5;

        // when 
        final LadderGame result = LadderGame.of(userCount, ladderHeight);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void play() {
        // given
        final Users users = UsersGenerator.generate("pobi,honux,crong,jk");
        final Prizes prizes = PrizesGenerator.generate("꽝,5000,꽝,3000");
        final LadderGame ladderGame = LadderGame.of(4, 5);

        // when
        final LadderGameResult result = ladderGame.play(users, prizes);

        // then
        assertThat(result.size()).isEqualTo(users.size());
    }
}
