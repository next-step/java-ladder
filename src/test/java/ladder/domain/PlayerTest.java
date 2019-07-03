package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {

    @Test
    void 플레이어는_이름으로_생성한다() {
        String testName = "test";
        Player player = Player.from(testName);

        assertThat(player.getName()).isEqualTo(testName);
    }

    @Test
    void 이름이_5글자가_넘으면_예외가_발생한다() {
        String moreThanFiveLetter = "moreThanFiveLetter";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Player.from(moreThanFiveLetter);
                });
    }

    @Test
    void 이름이_공백이면_예외가_발생한다() {
        String emptyName = "";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Player.from(emptyName);
                });
    }


}
