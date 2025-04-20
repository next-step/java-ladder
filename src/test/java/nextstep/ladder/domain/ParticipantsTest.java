package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParticipantsTest {
    List<Name> names;

    @BeforeEach
    void setUp() {
        names = List.of(new Name("p1"), new Name("p2"));
    }

    @Test
    @DisplayName("기본 생성자 동작 확인")
    void create() {
        assertThat(new Participants(names)).isInstanceOf(Participants.class);
    }

    @Test
    @DisplayName("참여자가 2명 미만인 경우 테스트 - 예외 발생")
    void invalid_name_size() {
        assertThatThrownBy(() -> new Participants(List.of(new Name("p1"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Participants.TOO_FEW_PARTICIPANTS_MESSAGE);
    }

    @Test
    @DisplayName("List를 위한 기본 메소드 동작 테스트")
    void basic_method_test() {
        Participants participants = new Participants(names);
        assertThat(participants.size()).isEqualTo(names.size());
        assertThat(participants.get(0)).isEqualTo(names.get(0));
        assertThat(participants.asList()).isEqualTo(names);
    }
}
