package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @DisplayName("참가자를 2명이상 입력해야 하지않으면 예외가 발생한다.")
    @Test
    void 참가자_두명미만_입력할떄() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participants(new String[]{"bobo"});
        });
    }

    @Test
    void toStringTest() {
            assertThat(new Participants(new String[]{"bobo", "mo"}).toString())
                    .isEqualTo("bobo  mo    ");
    }
}