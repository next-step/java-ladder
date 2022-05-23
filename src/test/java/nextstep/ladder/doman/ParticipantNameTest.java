package nextstep.ladder.doman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 이름이_Null이거나_비어있을때(String name) {
        assertThatThrownBy(() -> new ParticipantName(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"sanghok", "sanghyuk", "BillGates"})
    void 이름이_6글자_이상일경우(String name) {
        assertThatThrownBy(() -> new ParticipantName(name)).isInstanceOf(IllegalArgumentException.class);
    }
}
