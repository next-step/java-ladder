package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.NameLengthInvalidException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    @ParameterizedTest
    @CsvSource(value = "pobi:honux:crong:jk", delimiter = ':')
    void 정상_생성(final String name) {
        assertDoesNotThrow(() -> Participant.valueOf(name));
    }

    @ParameterizedTest
    @CsvSource(value = "pobiaa:honuxbbb:crongffff:jkeeee", delimiter = ':')
    void 다섯글자_초과시_에러(final String name) {
        assertThrows(NameLengthInvalidException.class, () -> Participant.valueOf(name));
    }
}