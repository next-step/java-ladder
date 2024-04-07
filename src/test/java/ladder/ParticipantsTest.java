package ladder;

import ladder.domain.Name;
import ladder.domain.Participants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParticipantsTest {
    private static final String SPLIT_DELIMITER = ",";

    @ParameterizedTest
    @ValueSource(strings = {"a,bb,ccc", "a,abcde"})
    void 참가자_생성(String input) {
        Participants participants = Participants.generateParticipants(input.split(SPLIT_DELIMITER, -1));
        assertThat(participants).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",,", "ab,a b", "a, b", "abc,abcdef"})
    void 적절하지_않은_참가자_생성(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Participants.generateParticipants(input.split(SPLIT_DELIMITER, -1)));
    }

    @Test
    void 참가자수() {
        Participants participants = Participants.generateParticipants(new String[]{"a", "bb", "ccc"});
        assertThat(participants.countOfPerson()).isEqualTo(3);
    }

    @Test
    void 인덱스로_이름_조회() {
        Participants participants = Participants.generateParticipants(new String[]{"a", "bb", "ccc"});
        assertThat(participants.nameOf(1)).isEqualTo(new Name("bb"));
    }
}
