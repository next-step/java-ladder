package nextstep.ladder.model;

import nextstep.ladder.utils.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayersTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"aaaa,bbbb,cccc,,dddd", "aaaaaa,bbbb,cccc"})
    @DisplayName("입력값에 null 이나 빈값, 또는 5글자 이상이 들어갔을 경우")
    void validationMiddleEmpty(String names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            String[] splitNames = StringUtils.validationNotNullAndEmpty(names).split(",");
            new Players(splitNames);
        });
    }

    @Test
    @DisplayName("Players에서 name으로 Player 찾기: 성공")
    void SuccessFindByName() {
        Players players = new Players("aaaa,bbbb,cccc".split(","));

        String target = "aaaa";
        Player player = players.findPlayerByName(target);
        assertThat(player.getName()).isEqualTo(target);
    }

    @Test
    @DisplayName("Players에서 name으로 Player 찾기: 실패")
    void FailFindByName() {
        Players players = new Players("aaaa,bbbb,cccc".split(","));
        String target = "dddd";
        assertThatIllegalArgumentException().isThrownBy(() -> players.findPlayerByName(target));
    }

    @Test
    @DisplayName("플레이어가 혼자일 경우 IllegalArgumentException 발생")
    void validationSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Players("aaaa".split(",")));
    }
}