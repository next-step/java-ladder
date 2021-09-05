package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {


    @Test
    @DisplayName("Ladder 생성 테스트")
    void createLadder() {
        Ladder ladder = new Ladder(new LadderHeight(3), 3);
        assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("count 예외 테스트")
    void countException() {
        assertThatThrownBy(() -> new Ladder(new LadderHeight(3), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("result() 테스트")
    @MethodSource("resultSource")
    void resultTest(Users users, WinningItems items) {
        Ladder ladder = new Ladder(new LadderHeight(3), 3 );
        List<Result> results = ladder.results(users, items);
        assertAll(
                () -> results.get(0).getUser().equals(new User("a")),
                () -> results.get(1).getUser().equals(new User("b")),
                () -> results.get(2).getUser().equals(new User("c")),

                () -> results.get(0).getWinningItem().equals(new WinningItem("1")),
                () -> results.get(1).getWinningItem().equals(new WinningItem("2")),
                () -> results.get(2).getWinningItem().equals(new WinningItem("3"))
        );
    }

    static Stream<Arguments> resultSource() {
        return Stream.of(
                Arguments.of(
                new Users(new String[] {"a", "b", "c"}),
                new WinningItems(new String[] {"1", "2", "3"})
        ));
    }
}