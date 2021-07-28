package nextstep.ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("게임 참가자 를 표현하는 플레이어 클래스 테스트")
class PlayerTest {

    @DisplayName("플레이어는 이름을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Player.from("name")).isInstanceOf(Player.class);
    }

    @DisplayName("플레이어 이름이 null 이거나 비어있거나 5글자를 초과하는 경우 예외를 발생 시킨다")
    @NullAndEmptySource
    @ValueSource(strings = {"nokcha", "nokchax"})
    void initException(String name) {
        assertThatThrownBy(() -> Player.from(name)).isInstanceOf(IllegalArgumentException.class);
    }

}
