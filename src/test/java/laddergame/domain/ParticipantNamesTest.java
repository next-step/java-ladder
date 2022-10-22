package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParticipantNamesTest {

    private final ParticipantNames participantNames = new ParticipantNames(List.of(new ParticipantName("a"), new ParticipantName("ab")));

    @DisplayName("중복된 이름의 참가자가 존재한다면, 예외가 발생해야 한다.")
    @Test
    void create_givenDuplicatedNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ParticipantNames(List.of(new ParticipantName("a"), new ParticipantName("a"))));
    }

    @DisplayName("문자열의 참가자 이름 목록을 전달하면, 인스턴스가 생성되어야 한다.")
    @Test
    void from() {
        assertThat(ParticipantNames.from(List.of("a", "ab"))).isEqualTo(participantNames);
    }

    @DisplayName("참가자 이름 목록의 크기를 반환해야 한다.")
    @Test
    void size() {
        assertThat(participantNames.size()).isEqualTo(2);
    }

    @DisplayName("인덱스를 전달하면, 해당 인덱스의 참가자 이름을 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "0,a",
            "1,ab"
    })
    void get(int index, String expectedValue) {
        assertThat(participantNames.get(index)).isEqualTo(new ParticipantName(expectedValue));
    }

    @DisplayName("범위를 벗어나는 인덱스를 전달하면, 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 2})
    void get_givenIndexOutOfRange(int index) {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> participantNames.get(index));
    }

}
