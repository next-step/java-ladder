package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import nextstep.ladder.exception.NotEnoughPlayersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayersTest {

    static Stream<Arguments> generateNames() {
        List<Name> names = new ArrayList<>();
        names.add(Name.from("pobi"));
        names.add(Name.from("honux"));
        names.add(Name.from("crong"));
        names.add(Name.from("jk"));

        return Stream.of(Arguments.of(names, 4));
    }

    @ParameterizedTest
    @MethodSource("generateNames")
    @DisplayName("생성 성공")
    void create(List<Name> players, int size) {
        assertThat(new Players(players).size()).isEqualTo(size);
    }

    @Test
    @DisplayName("인원이 없을 경우 예외처리")
    void notEnoughPlayersException() {
        List<Name> players = new ArrayList<>();
        assertThatExceptionOfType(NotEnoughPlayersException.class)
            .isThrownBy(() -> new Players(players));
    }

}
