package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import ladder.domain.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ParticipantTest {

    @Test
    @DisplayName("참가자 이름이 유입되었을 경우 정상객체를 생성한다.")
    void objCreateTest() {
        assertDoesNotThrow(() -> new Participant("test"));
    }

    @ParameterizedTest(name = "null or 빈 문자열 유입시 에러를 발생한다.")
    @NullAndEmptySource
    void nullAndEmptyTest(String source) {
        assertThatThrownBy(() -> new Participant(source))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자명이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("참여자 이름이 5글자를 초과했을 경우 익셉션을 발생시킨다.")
    void tooLongName() {
        assertThatThrownBy(() -> new Participant("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("참여자 이름이 1 일경우 나머지 공간인 4를 리턴한다.")
    void restSpaceTest() {
        assertThat(new Participant("a").restSpace())
                .isEqualTo(4);
    }
}
