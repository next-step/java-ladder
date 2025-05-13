package nextstep.ladder2.ladder;

import nextstep.ladder2.domain.ladder.Ladder;
import nextstep.ladder2.domain.ladder.Line;
import nextstep.ladder2.domain.result.MatchingResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            int result = ladder.resultOf(i);
            assertThat(result).isBetween(0, peopleCount - 1);
        }
    }
    
    @Test
    void 유효하지_않은_위치로_결과를_요청하면_예외가_발생한다() {
        Ladder ladder = new Ladder(3, 5);
        
        assertThatIllegalArgumentException().isThrownBy(() -> ladder.resultOf(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> ladder.resultOf(3));
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

        List<Integer> playerRewardIndexList = result.playerRewardList();
        Set<Integer> actual = new HashSet<>(playerRewardIndexList);
        Set<Integer> expected = new HashSet<>(List.of(0, 1, 2, 3, 4));

        assertThat(actual).isEqualTo(expected);
    }
}