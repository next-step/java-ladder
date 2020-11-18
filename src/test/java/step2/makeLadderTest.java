package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.ladder.LadderGame;
import step2.domain.ladder.LadderPlayers;
import step2.domain.ladder.Line;
import step2.domain.ladder.Point;
import step2.strategy.MakeLineStrategy;
import step2.strategy.TestLineMakeStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class makeLadderTest {
    private MakeLineStrategy allTrueStrategy;
    private MakeLineStrategy allFalseStrategy;

    @BeforeEach
    void setup() {
        allTrueStrategy = new TestLineMakeStrategy(){
            @Override
            public List<Boolean> create(int countOfPerson) {
                return IntStream.range(0, countOfPerson - 1)
                        .mapToObj((index)->true)
                        .collect(Collectors.toList());
            }
        };
        allFalseStrategy = new TestLineMakeStrategy(){
            @Override
            public List<Boolean> create(int countOfPerson) {
                return IntStream.range(0, countOfPerson - 1)
                        .mapToObj((index)->false)
                        .collect(Collectors.toList());
            }
        };
    }




    @DisplayName("라인 생성 전략")
    @Test
    void executeLineStrategy() {
        Line allMarkedLine = new Line(4, (count) -> IntStream.range(0, count-1).mapToObj(i -> true).collect(Collectors.toList()));
        Line allUnMarkedLine = new Line(4, (count) -> IntStream.range(0, count-1).mapToObj(i -> false).collect(Collectors.toList()));

        assertThat(allMarkedLine.isExistsPoint(new Point(1,1))).isTrue();
        assertThat(allMarkedLine.isExistsPoint(new Point(2,1))).isTrue();
        assertThat(allMarkedLine.isExistsPoint(new Point(3,1))).isTrue();

        assertThat(allUnMarkedLine.isExistsPoint(new Point(1,1))).isFalse();
        assertThat(allUnMarkedLine.isExistsPoint(new Point(2,2))).isFalse();
        assertThat(allUnMarkedLine.isExistsPoint(new Point(3,3))).isFalse();

    }

    @DisplayName("사다리 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderPlayersAndLadderHeight")
    void makeLadder(LadderPlayers players, int height) {
//        Ladder ladder = LadderGame.makeLadder(new LadderBuildDTO(players, height), allTrueStrategy);
        System.out.println(players.toString());

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < players.count()-1; j++) {
//                assertThat(ladder.isExistsPoint(new LinePoint(j,i))).isTrue();
//            }
//        }

    }

    private static Stream<Arguments> provideLadderPlayersAndLadderHeight() {
        return Stream.of(
                Arguments.of(LadderGame.join("pobi,crong,haha,bibi"), 5)
        );
    }
}
