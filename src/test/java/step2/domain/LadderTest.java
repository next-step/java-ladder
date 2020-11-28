package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.LadderDto;
import step2.dto.PlayersRewardsDto;
import step2.exception.LadderHeightException;
import step2.exception.NotMatchPlayerRewardsCountException;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("사다리 높이가 0일경우 익셉션 발생")
    void throwLadderHeightException() {
        assertThatThrownBy(() -> Ladder.of(
                new PlayersRewardsDto(Players.of(Collections.emptyList()), Rewards.of(Collections.emptyList())),
                new LadderDto(0, new MustLineStrategy())))
                .isInstanceOf(LadderHeightException.class);
    }

    @Test
    @DisplayName("리워드의 숫자와 플레이어의 숫자가 일치하지 않을경우 익셉션 발생")
    void throwPlayerRewardsCountException() {
        assertThatThrownBy(() -> Ladder.of(
                new PlayersRewardsDto(Players.of(Arrays.asList("name")), Rewards.of(Collections.emptyList())),
                new LadderDto(1, new MustLineStrategy())))
                .isInstanceOf(NotMatchPlayerRewardsCountException.class);
    }

    @Test
    @DisplayName("Ladder가 잘 생성되는지 확인한다.")
    void create() {
        Ladder ladder = Ladder.of(new PlayersRewardsDto(Players.of(Arrays.asList("a", "b")), Rewards.of(Arrays.asList("a", "b")))
                , new LadderDto(2, new MustLineStrategy()));

        assertThat(ladder)
                .isEqualTo(Ladder.of(new PlayersRewardsDto(Players.of(Arrays.asList("a", "b")), Rewards.of(Arrays.asList("a", "b")))
                        , new LadderDto(2, new MustLineStrategy())));
    }

}