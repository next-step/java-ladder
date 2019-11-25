package ladder.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantsTest {
    private Participants participants;

    @BeforeEach
    void setUp() {
        participants = new Participants("한명, 두명, 세명, 네명");
    }

    @Test
    @DisplayName("사용자를 한명만 입력해서 예외발생")
    void constructorExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Participants("한명"));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "한명:0",
            "두명:1",
            "세명:2",
            "네명:3"
    }, delimiter = ':')
    @DisplayName("참여자의 이름으로 인덱스조회")
    void indexOf(String name, int index) {
        assertThat(participants.indexOf(name)).isEqualTo(index);
    }
}