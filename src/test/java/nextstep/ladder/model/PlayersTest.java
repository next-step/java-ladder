package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"aaaa,bbbb,cccc,,dddd", "aaaaaa,bbbb,cccc"})
    @DisplayName("배열에 빈값 또는 5글자 이상이 들어갔을 경우")
    void validationMiddleEmpty(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Players(names.split(",")));
    }

    @Test
    @DisplayName("Players에서 name으로 Player 찾기: 성공")
    void successFindByName() {
        Players players = new Players("aaaa,bbbb,cccc".split(","));

        String target = "aaaa";
        Player player = players.findPlayerByName(target);
        assertThat(player.getName()).isEqualTo(target);
    }

    @Test
    @DisplayName("Players에서 name으로 Player 찾기: 실패")
    void failFindByName() {
        Players players = new Players("aaaa,bbbb,cccc".split(","));
        String target = "dddd";
        assertThatIllegalArgumentException().isThrownBy(() -> players.findPlayerByName(target));
    }

    @Test
    @DisplayName("플레이어가 혼자일 경우 IllegalArgumentException 발생")
    void validationSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Players("aaaa".split(",")));
    }

    @Test
    @DisplayName("Players에서 Index로 Player 찾기: 성공")
    void successFindByIndex() {
        Players players = new Players("aaaa,bbbb,cccc".split(","));
        Index index = new Index(1);

        Player player = players.findPlayerByIndex(index);

        assertThat(player.getName()).isEqualTo("bbbb");
    }

    @Test
    @DisplayName("Players에서 Index로 Player 찾기: 실패")
    void failFindByIndex() {
        Players players = new Players("aaaa,bbbb,cccc".split(","));
        Index index = new Index(3);

        assertThatIllegalArgumentException().isThrownBy(() -> players.findPlayerByIndex(index));
    }
}