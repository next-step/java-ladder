package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참가자를 반환 한다.")
    @Test
    void getParticipantsInfo() {
        // given
        List<String> users = List.of("yang", "gang", "eee");
        List<String> winningProducts = List.of("1등", "2등", "3등");
        RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

        // when
        Ladder ladder = Ladder.of(4, users, winningProducts, randomLineStrategy);

        // then
        assertThat(ladder.getParticipants()).contains("yang", "gang", "eee");
    }

    @DisplayName("사다리 정보를 반환한다.")
    @Test
    void getLadderInfo() {
        // given
        List<String> users = List.of("yang", "gang", "eee");
        List<String> winningProducts = List.of("1등", "2등", "3등");

        // when
        Ladder ladder = Ladder.of(7, users, winningProducts, new RandomLineStrategy());
        List<Line> ladderInfo = ladder.getLadderInfo();

        // then
        assertThat(ladderInfo).hasSize(7);
    }

    @DisplayName("유저 개수와 결과 상품 개수가 다르면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenCountOfUsersAndCountOfWinningProductsNotSame() {
        // given
        List<String> users = List.of("yang", "gang", "eee");
        List<String> winningProducts = List.of("1등", "2등");

        // then
        Assertions.assertThatThrownBy(() -> Ladder.of(7, users, winningProducts, new RandomLineStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
