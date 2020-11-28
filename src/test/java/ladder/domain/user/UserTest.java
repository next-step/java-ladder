package ladder.domain.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.domain.Position;
import ladder.exception.LadderGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class UserTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 유저이름_공백_Null_테스트(String given) {
        Position givenCoordinate = new Position(0);
        assertThrows(LadderGameException.class, () -> User.of(given, givenCoordinate));
    }

    @Test
    void 유저이름_6글자_테스트() {
        String length6 = "test12";
        Position givenCoordinate = new Position(0);
        assertThrows(LadderGameException.class, () -> User.of(length6, givenCoordinate));
    }
}