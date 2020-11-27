package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.LadderHeightException;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("네임이 5글자를 초과하는경우 익셉션 발생")
    void throwLadderHeightException() {
        assertThatThrownBy(() -> Ladder.of(Players.of(Collections.emptyList()), 0, new MustLineStrategy()))
                .isInstanceOf(LadderHeightException.class);
    }

    @Test
    @DisplayName("Ladder가 잘 생성되는지 확인한다.")
    void create() {
        Ladder ladder = Ladder.of(Players.of(Arrays.asList(Player.of("a"), Player.of("b"))), 2, new MustLineStrategy());

        assertThat(ladder)
                .isEqualTo(Ladder.of(Players.of(Arrays.asList(Player.of("a"), Player.of("b"))), 2, new MustLineStrategy()));
    }

}