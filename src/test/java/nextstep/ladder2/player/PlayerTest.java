package nextstep.ladder2.player;

import nextstep.ladder2.domain.player.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    public void 플레이어이름은_최대5글자여야한다() {
        Player player = new Player("abcde");
        assertThat(player.name().length() <= 5).isTrue();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"abcdef"})
    public void 빈공백이나_null_또는_6글자이상은_입력될수없다(String str) {
        assertThatThrownBy(() -> {
            new Player(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}