package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 02:11
 */
public class ParticipantTest {

    @DisplayName("입력된 사용자의 count 가지고 오기")
    @Test
    void countCustoms() {
        List<String> customName = Arrays.asList("kwon", "byeon", "yun");

        Participant participant = Participant.of(customName);
        assertThat(participant.count()).isEqualTo(3);
    }

    @DisplayName("입력된 사용자가 비어있을 경우")
    @Test
    void isEmptyCustom() {
        List<String> names = Arrays.asList();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Participant participant = Participant.of(names);
        }).withMessageContaining("사람이 입력되지 않았습니다.");
    }

    @DisplayName("List가 null일 경우")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullCustom(List<String> names) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Participant participant = Participant.of(names);
        }).withMessageContaining("사람이 입력되지 않았습니다.");
    }

    @DisplayName("Name과 index 번호를 통해 일치하는 정보가 있는지 확인")
    @Test
    void matchAttribute() {
        List<String> customName = Arrays.asList("kwon", "byeon", "yun");
        Participant participant = Participant.of(customName);

        assertThat(participant.matchAttribute(Name.of("kwon"), 0)).isTrue();
    }
}
