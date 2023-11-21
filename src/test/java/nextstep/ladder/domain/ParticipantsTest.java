package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {

    @Test
    void create() {
        Participants participants = new Participants("popo,bobo");
        assertThat(participants).isEqualTo(new Participants("popo,bobo"));
    }

    @DisplayName("참가자를 입력하지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void 빈문자열_또는_공백_일떄(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participants(input);
        });
    }

    @DisplayName("참가자를 2명이상 입력해야 하지않으면 예외가 발생한다.")
    @Test
    void 참가자_두명미만_입력할떄() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Participants("bobo");
        });
    }

    @Test
    void toStringTest() {
            assertThat(new Participants("bobo,mo").toString())
                    .isEqualTo("bobo  mo    ");
    }
}