package nextstep.ladders.domain;

import nextstep.ladders.exception.NameLengthInvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    @ParameterizedTest
    @CsvSource(value = "pobi:honux:crong:jk", delimiter = ':')
    @DisplayName("생성 테스트")
    void create(final String name) {
        assertDoesNotThrow(() -> Participant.valueOf(name));
    }

    @ParameterizedTest
    @CsvSource(value = "pobiaa:honuxbbb:crongffff:jkeeee", delimiter = ':')
    @DisplayName("참가자 이름이 다섯글자를 초과할시 에러")
    void errorWhenParticipantNameExceedsFiveCharacters(final String name) {
        assertThrows(NameLengthInvalidException.class, () -> Participant.valueOf(name));
    }
}