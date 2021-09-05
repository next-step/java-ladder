package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("게임 참가자 테스트")
public class PlayerTest {

    @DisplayName("참가자 이름이 비어있으면 예외가 발생한다.")
    @Test
    void emptyNameExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(null))
                .withMessage("참가자 이름이 비어있습니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(""))
                .withMessage("참가자 이름이 비어있습니다.");
    }

    @DisplayName("참가자 이름이 5자를 넘어가면 예외가 발생한다.")
    @Test
    void exceedMaxNameLengthExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("abcdef"))
                .withMessage("참가자 이름은 5자를 넘을 수 없습니다.");
    }

    @DisplayName("참가자 이름이 주입받은 이름 그대로 정상 생성되어야 한다.")
    @Test
    void createPlayerNameTest() {
        // given, when
        Player player = new Player("aiden");

        // then
        assertEquals(player.getName(), "aiden");
    }

    @DisplayName("참가자 이름 동일 여부 조회시, 이름이 5자가 넘어가면 예외가 발생한다.")
    @Test
    void exceedMaxLengthWhenMatchNameExceptionTest() {
        // given, when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("aiden").matchName("abcdef"))
                .withMessage("참가자 이름은 5자를 넘을 수 없습니다.");
    }

    @DisplayName("플레이어 이름 동일 여부 기능이 정상 동작해야 한다.")
    @Test
    void matchPlayerNameTest() {
        // given
        Player player = new Player("aiden");

        // when, then
        assertTrue(player.matchName("aiden"));
        assertFalse(player.matchName("pobi"));
    }
}
