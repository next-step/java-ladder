package step2;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @TestFactory
    Stream<DynamicTest> 참가자_리스트에_대한_예외() {
        return Stream.of(
                DynamicTest.dynamicTest("null이면 예외", () -> {
                    assertThatThrownBy(() -> {
                        Players.newPlayers(null);
                    }).isInstanceOf(IllegalArgumentException.class);
                }),
                DynamicTest.dynamicTest("2명 미만이면 예외", () -> {
                    assertThatThrownBy(() -> {
                        Players.newPlayers("이병덕");
                    }).isInstanceOf(IllegalArgumentException.class);
                })
        );
    }

    @Test
    void 참가자_명단_생성() {
        // given
        Players expectPlayers = new Players(Arrays.asList(Player.newPlayer("이병덕"), Player.newPlayer("박효신")));

        // then
        assertThat(Players.newPlayers("이병덕,박효신")).isEqualTo(expectPlayers);
    }
}