package ladder.domain.core.line.name;

import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.core.line.name.Name.ERROR_MESSAGE_MAX_LEN_NAME;
import static ladder.domain.core.line.name.Name.ERROR_MESSAGE_REQUIRED_NAME;
import static ladder.domain.core.line.name.Name.ERROR_MESSAGE_SUITABLE_NAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {
    @DisplayName("참여하는 사람에 이름은 공백이나 null일수 없음")
    @Test
    void name_blankNameTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Name(null, Name::verifyBlankName))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Name("", Name::verifyBlankName))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Name(" ", Name::verifyBlankName))
            .withMessage(ERROR_MESSAGE_REQUIRED_NAME);
    }

    @DisplayName("참여하는 사람에 이름을 알파벳(a-z), 숫자(0-9)포함 5글자  부여")
    @Test
    void participant_suitableNameTest () {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Name.ofParticipant("1"))
            .withMessage(ERROR_MESSAGE_SUITABLE_NAME);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> Name.ofParticipant("abcdef"))
            .withMessage(ERROR_MESSAGE_SUITABLE_NAME);
    }

    @DisplayName("최대 문자 길이 체크")
    @Test
    void ladderResult_maxNameLengthTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Name.ofLadderResults("꽝꽝꽝꽝꽝꽝"))
            .withMessage(ERROR_MESSAGE_MAX_LEN_NAME);
    }

    @DisplayName("이름 비교 테스트")
    @Test
    void nameTest() {
        Name n1 = new Name("a", Name::verifyBlankName);
        Name n2 = new Name("b", Name::verifyBlankName);
        assertThat(n1.equals(n2)).isFalse();
    }

    @DisplayName("이름 중복 확인")
    @Test
    void name() {
        Set<Name> s = Sets.newLinkedHashSet(new Name("a"), new Name("b"), new Name("b"));
        assertThat(s.size()).isEqualTo(2);
    }
}
