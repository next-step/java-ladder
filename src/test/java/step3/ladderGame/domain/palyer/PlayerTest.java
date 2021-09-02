package step3.ladderGame.domain.palyer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class PlayerTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Player("qwer", 5)).isInstanceOf(Player.class);
    }

    @DisplayName("이름이 null이거나 없을 경우 에러발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validate_이름이_null이거나_없을_경우_에러(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player(input, 5);
        }).withMessageMatching("입력값이 없습니다.");
    }

    @DisplayName("이름의 길이가 1~5가 아닐 경우 에러발생")
    @Test
    void validate_이름의_길이가_1에서_5_사이가_아닐_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player("test12345", 5);
        }).withMessageMatching("1~5글자 사이로 입력해야 합니다.");
    }

    @DisplayName("인덱스가 0 미만일 경우 에러발생")
    @ParameterizedTest
    @ValueSource(ints = {-5, -50})
    void validate_인덱스가_0_미만일_경우_에러(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Player("abc", input);
        }).withMessageMatching("index는 0이상이어야 합니다.");
    }

}
