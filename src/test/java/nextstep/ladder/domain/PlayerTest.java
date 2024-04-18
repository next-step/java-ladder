package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("이름은 5글자 이하만 가능하다")
    @Test
    void tooLongName() {
        assertThatThrownBy(() -> new Player(0, "123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름은 비어있을 수 없다")
    @ParameterizedTest(name = "name = {0}")
    @NullAndEmptySource
    void emptyName(String name) {
        assertThatThrownBy(() -> new Player(0, name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인덱스는 0보다 작을 수 없다")
    @Test
    void negativeIndex() {
        assertThatThrownBy(() -> new Player(-1, "hello")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("인덱스가 같은지 비교")
    @ParameterizedTest(name = "index = {0}, targetIndex = {1}, expected = {2}")
    @CsvSource(value = {"0,0,true", "1,0,false"})
    void sameIndex(int index, int targetIndex, boolean expected) {
        Player player = new Player(index, "hello");

        assertThat(player.sameIndex(targetIndex)).isEqualTo(expected);
    }

}
