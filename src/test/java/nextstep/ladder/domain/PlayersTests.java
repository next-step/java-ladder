package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNamesEmptyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTests {
    @DisplayName("참여자 이름을 컬렉션으로 전달 받아서 일급 콜렉션을 생성할 수 있다.")
    @Test
    void createTest() {
        List<String> nameValues = Arrays.asList("poppo", "ita", "saul");
        Players players = Players.create(nameValues);
        assertThat(players).isNotNull();
        assertThat(players.size()).isEqualTo(3);
    }

    @DisplayName("참여자 이름 컬렉션이 비어있거나 null일 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    @MethodSource("invalidPlayerNameList")
    void createValidationTest(List<String> invalidPlayerNameList) {
        assertThatThrownBy(() -> Players.create(invalidPlayerNameList)).isInstanceOf(PlayerNamesEmptyException.class);
    }
    public static Stream<ArrayList> invalidPlayerNameList() {
        return Stream.of(new ArrayList());
    }

    @DisplayName("현재 객체의 가장 긴 이름의 길이를 알려줄 수 있다.")
    @ParameterizedTest
    @MethodSource("nameValuesSource")
    void getMaxNameLengthTest(List<String> nameValues, int resultSize) {
        Players players = Players.create(nameValues);
        assertThat(players.size()).isEqualTo(3);
        assertThat(players.getMaxNameLength()).isEqualTo(resultSize);
    }
    public static Stream<Arguments> nameValuesSource() {
        return Stream.of(
                Arguments.of(Arrays.asList("poppo", "ita", "saul"), 5),
                Arguments.of(Arrays.asList("pop", "ita", "saul"), 4)
        );
    }

    @DisplayName("이름 순서대로 초기 사다리 위치가 설정된다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, 1, 2 })
    void locationTest(int nameIndex) {
        Players players = Players.create(Arrays.asList("poppo", "ita", "saul"));
        HorizontalLocation location = players.getLocationOfIndex(nameIndex);
        assertThat(location).isEqualTo(new HorizontalLocation(nameIndex, 3));
    }

    @DisplayName("속해 있는 Player 객체들의 게임을 진행할 수 있다.")
    @Test
    void playLadderGameAllTest() {
        Ladder ladder = Ladder.create(5, 3, new SimplePointAddStrategy());
        Players players = Players.create(Arrays.asList("poppo", "ita", "saul"));
        players.playLadderGame(ladder);
        
        HorizontalLocation location = players.getLocationOfIndex(0);

        assertThat(location).isEqualTo(new HorizontalLocation(1, 3));
    }
}
