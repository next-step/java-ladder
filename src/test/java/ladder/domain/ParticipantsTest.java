package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsTest {

    @Test
    @DisplayName("중복된 이름으로 사다리게임에 참여할 수 없다.")
    void duplicateNameTest() {
        List<String> names = List.of("name", "name");

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(names))
                .withMessageContaining("중복된 이름이 있습니다");
    }
}