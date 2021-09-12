package ladder.domain;

import ladder.domain.game.GameResult;
import ladder.exception.InvalidForGameResult;
import ladder.helper.Fixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("GameResult : 게임의 결과 정보를 담고 처리하는 클래스")
public class GameResultTest {
    @DisplayName("GameResult 인스턴스를 생성한다.")
    @Test
    void create() {
        assertThat(new GameResult(Fixture.participants(), Fixture.prizeName(), Fixture.ladderSize())).isNotNull();
    }

    @DisplayName("입력된 prize의 개수가 게임 참가자의 수와 일치하지 않으면 Exception 발생")
    @Test
    void validate() {
        String[] prizeName = IntStream.rangeClosed(1, 9)
                .mapToObj((n) -> Integer.toString(n))
                .toArray(String[]::new);
        assertThatThrownBy(() -> new GameResult(Fixture.participants(), prizeName, Fixture.ladderSize())).isInstanceOf(InvalidForGameResult.class);
    }

    @DisplayName("GameResult는 Participant의 현재 위치와 일치하는 Prize를 mapping하여 저장한다. findResult를 통해 Prize 결과를 얻을 수 있다.")
    @ParameterizedTest(name = "{arguments} {displayName}")
    @MethodSource("sourceFindResult")
    void findResult(String nameOfParticipant, String expected) {
        assertThat(Fixture.gameResult().findResult(nameOfParticipant)).isEqualTo(expected);
    }

    static Stream<Arguments> sourceFindResult() {
        return Stream.of(
                Arguments.of("man1", "prz1"),
                Arguments.of("man2", "prz2"),
                Arguments.of("man3", "prz3"),
                Arguments.of("man4", "prz4"),
                Arguments.of("man5", "prz5"),
                Arguments.of("man6", "prz6"),
                Arguments.of("man7", "prz7"),
                Arguments.of("man8", "prz8"),
                Arguments.of("man9", "prz9"),
                Arguments.of("man10", "prz10")
        );
    }
}
