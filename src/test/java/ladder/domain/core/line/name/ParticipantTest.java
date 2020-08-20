package ladder.domain.core.line.name;

import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.core.line.name.BaseName;
import ladder.domain.core.line.name.Participant;

import static ladder.domain.core.line.name.BaseName.ERROR_MESSAGE_REQUIRED_NAME;
import static ladder.domain.core.line.name.Participant.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantTest {
    @DisplayName("참여하는 사람에 이름은 공백이나 null일수 없음")
    @Test
    void blankNameTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant(null))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant(""))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant(" "))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);
    }

    @DisplayName("참여하는 사람에 이름을 알파벳(a-z), 숫자(0-9)포함 5글자  부여")
    @Test
    void maxLengthNameTest () {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant("1"))
            .withMessage(ERROR_MESSAGE_SUITABLE_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Participant("abcdef"))
            .withMessage(ERROR_MESSAGE_SUITABLE_NAME);
    }

    @DisplayName("이름 비교 테스트")
    @Test
    void nameTest() {
        BaseName n1 = new Participant("a");
        BaseName n2 = new Participant("b");
        assertThat(n1.equals(n2)).isFalse();
    }

    @DisplayName("이름 중복 확인")
    @Test
    void name() {
        Set<BaseName> s = Sets.newLinkedHashSet(new Participant("a"), new Participant("b"), new Participant("b"));
        assertThat(s.size()).isEqualTo(2);
    }
}
