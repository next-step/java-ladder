package nextstep.ladder2.ladder;

import nextstep.ladder2.domain.ladder.Ladder;
import nextstep.ladder2.domain.ladder.Line;
import nextstep.ladder2.domain.ladder.Position;
import nextstep.ladder2.domain.result.MatchingResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    void 사다리_사이즈는_1이상이어야한다() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Ladder(0, 0)
        );
    }

    @Test
    void 입력한수치만큼의_사다리가_생성된다() {
        Ladder ladder = new Ladder(3, 5);
        
        assertThat(ladder.height()).isEqualTo(5);
        assertThat(ladder.lines()).hasSize(5);
        
        for (Line line : ladder.lines()) {
            assertThat(line.size()).isEqualTo(3);
        }
    }

    @Test
    void 사다리게임을_play하면_결과를_생성한다() {
        Ladder ladder = new Ladder(3, 5);
        
        MatchingResult matchingResult = ladder.play();
        
        assertThat(matchingResult).isNotNull();
    }
    
    @Test
    void 사다리의_각_포지션은_항상_결과값을_가진다() {
        int peopleCount = 4;
        Ladder ladder = new Ladder(peopleCount, 10);
        
        for (int i = 0; i < peopleCount; i++) {
            Position result = ladder.resultOf(Position.of(i, 4));
            assertThat(result.value()).isBetween(0, peopleCount - 1);
        }
    }
    
    @Test
    void 유효하지_않은_위치로_결과를_요청하면_예외가_발생한다() {
        Ladder ladder = new Ladder(3, 5);
        
        assertThatIllegalArgumentException().isThrownBy(() -> ladder.resultOf(Position.of(-1, 3)));
        assertThatIllegalArgumentException().isThrownBy(() -> ladder.resultOf(Position.of(3, 3)));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void 사다리높이가_다양하게_생성된다(int height) {
        Ladder ladder = new Ladder(3, height);
        
        assertThat(ladder.height()).isEqualTo(height);
        assertThat(ladder.lines()).hasSize(height);
    }
    
    @Test
    void play메서드는_모든포지션에_대한_결과를_반환한다() {
        int peopleCount = 5;
        Ladder ladder = new Ladder(peopleCount, 10);
        
        MatchingResult result = ladder.play();

        List<Position> playerRewardIndexList = result.playerRewardList();
        Set<Position> actual = new HashSet<>(playerRewardIndexList);
        Set<Position> expected = new HashSet<>(Position.range(0, 5, peopleCount));

        assertThat(actual).isEqualTo(expected);
    }
}