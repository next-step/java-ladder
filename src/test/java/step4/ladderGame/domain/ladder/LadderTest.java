package step4.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateRandomDirectionStrategy;
import step4.ladderGame.domain.palyer.Players;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class LadderTest {

    private static final GenerateRandomDirectionStrategy generateStrategy = new GenerateRandomDirectionStrategy();

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Ladder(5, 5, generateStrategy)).isInstanceOf(Ladder.class);
    }

    @DisplayName("참가자가 두명 미만일 경우 에러 발생")
    @Test
    void validate_참가자가_두명_미만일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(1, 5, generateStrategy);
        }).withMessageMatching("참가자는 두명 이상이어야 합니다.");
    }

    @DisplayName("사다리 높이가 1 미만일 경우 에러 발생")
    @Test
    void validate_사다리_높이가_1미만일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Ladder(5, 0, generateStrategy);
        }).withMessageMatching("사다리 높이는 1 이상이어야 합니다.");
    }

    @DisplayName("이동")
    @Test
    void move() {
        Ladder ladder = new Ladder(5, 5, generateStrategy);
        assertThat(ladder.move(1)).isInstanceOf(Integer.class);
    }

    @DisplayName("사다리가 규칙에 맞게 잘 정상적으로 잘 생성 되는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLadder")
    void 사다리_생성_테스트(Ladder ladder, List<List<Direction>> shape) {
        assertThat(ladder.stream()
                .map(ladderLine -> ladderLine.stream()
                        .map(point -> point.getDirection())
                        .collect(Collectors.toList())
                ).collect(Collectors.toList()))
                .isEqualTo(shape);
    }

    private static Stream<Arguments> provideLadder() {
        Players players = new Players("aa,bb,cc,dd");
        Height height = Height.valueOf(3);

        return Stream.of(
                Arguments.of(
                        Ladder.of(players.count(), height.getValue(), generateStrategy),
                        Arrays.asList(
                                Arrays.asList(Direction.of(false, true), Direction.of(true, false), Direction.of(false, true), Direction.of(true, false)),
                                Arrays.asList(Direction.of(false, true), Direction.of(true, false), Direction.of(false, true), Direction.of(true, false)),
                                Arrays.asList(Direction.of(false, true), Direction.of(true, false), Direction.of(false, true), Direction.of(true, false))
                        )
                ),
                Arguments.of(
                        Ladder.of(players.count(), height.getValue(), generateStrategy),
                        Arrays.asList(
                                Arrays.asList(Direction.of(false, true), Direction.of(false, true), Direction.of(false, true), Direction.of(false, true)),
                                Arrays.asList(Direction.of(false, true), Direction.of(false, true), Direction.of(false, true), Direction.of(false, true)),
                                Arrays.asList(Direction.of(false, true), Direction.of(false, true), Direction.of(false, true), Direction.of(false, true))
                        )
                ),
                Arguments.of(
                        Ladder.of(players.count(), height.getValue(), generateStrategy),
                        Arrays.asList(
                                Arrays.asList(Direction.of(true, false), Direction.of(true, false), Direction.of(true, false), Direction.of(true, false)),
                                Arrays.asList(Direction.of(true, false), Direction.of(true, false), Direction.of(true, false), Direction.of(true, false)),
                                Arrays.asList(Direction.of(true, false), Direction.of(true, false), Direction.of(true, false), Direction.of(true, false))
                        )
                ),
                Arguments.of(
                        Ladder.of(players.count(), height.getValue(), generateStrategy),
                        Arrays.asList(
                                Arrays.asList(Direction.of(false, false), Direction.of(false, false), Direction.of(false, false), Direction.of(false, false)),
                                Arrays.asList(Direction.of(false, false), Direction.of(false, false), Direction.of(false, false), Direction.of(false, false)),
                                Arrays.asList(Direction.of(false, false), Direction.of(false, false), Direction.of(false, false), Direction.of(false, false))
                        )
                )
        );
    }

}
