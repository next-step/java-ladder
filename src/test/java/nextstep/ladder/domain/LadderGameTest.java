package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @DisplayName("참가자를 반환 한다.")
    @Test
    void getParticipantsInfo() {
        // given
        List<String> users = List.of("yang", "gang", "eee");
        List<String> winningProducts = List.of("1등", "2등", "3등");
        RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

        // when
        LadderGame ladderGame = new LadderGame(users, 4, winningProducts, randomLineStrategy);

        // then
        assertThat(ladderGame.getParticipants())
                .contains("yang", "gang", "eee");
    }

    @DisplayName("유저 개수와 결과 상품 개수가 다르면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenCountOfUsersAndCountOfWinningProductsNotSame() {
        // given
        List<String> users = List.of("yang", "gang", "eee");
        List<String> winningProducts = List.of("1등", "2등");

        // then
        assertThatThrownBy(() -> new LadderGame(users, 7, winningProducts, new RandomLineStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 리스트에 없는 참가자를 입력하면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionIfNotInList() {
        List<String> users = List.of("yang", "gang", "eee");
        List<String> winningProducts = List.of("1등", "2등", "3등");
        RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

        // when
        LadderGame ladderGame = new LadderGame(users, 4, winningProducts, randomLineStrategy);

        // then
        assertThatThrownBy(() -> ladderGame.getWinProduct("poppa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자의 당첨 상품을 받을 수 있다.")
    @Test
    void getUserWinProduct() {
        // given
        List<String> users = List.of("yang", "gang", "eee", "aaa", "ooo");
        List<String> winningProducts = List.of("1등", "2등", "3등", "4등", "5등");
        LineStrategy customStrategy = (count) -> Line.of(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));

        // when
        LadderGame ladderGame = new LadderGame(users, 1, winningProducts, customStrategy);

        // then
        assertAll(
                () -> Assertions.assertThat(ladderGame.getWinProduct("yang")).isEqualTo("2등"),
                () -> Assertions.assertThat(ladderGame.getWinProduct("gang")).isEqualTo("1등"),
                () -> Assertions.assertThat(ladderGame.getWinProduct("eee")).isEqualTo("4등"),
                () -> Assertions.assertThat(ladderGame.getWinProduct("aaa")).isEqualTo("3등"),
                () -> Assertions.assertThat(ladderGame.getWinProduct("ooo")).isEqualTo("5등")
        );
    }
}