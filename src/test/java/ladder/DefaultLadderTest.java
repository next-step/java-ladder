package ladder;

import ladder.domain.DefaultLadder;
import ladder.domain.Ladder;
import ladder.domain.LadderLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.util.Arrays;

import static ladder.domain.LevelItem.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DefaultLadderTest {

    @DisplayName("사디리높이가 1보다 작으면 exception 을 던진다")
    @Test
    void illegalHeight(){
        assertThatThrownBy( () -> new DefaultLadder(Arrays.asList("nio", "hoon", "mit"), Arrays.asList("0", "1000", "2000"), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 참가자수와 결과수가 동일하지 않으면 exception 을 던진다")
    @Test
    void illegalMembersAndResults(){
        assertThatThrownBy( () -> new DefaultLadder(Arrays.asList("nio", "hoon", "mit"), Arrays.asList("0", "1000"), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참가자 이름을 입력하면 결과를 알려준다")
    @Test
    void getMemberResult(){
        Ladder ladder = new DefaultLadder(
                Arrays.asList("nio", "hoon", "mit"),
                Arrays.asList("1000", "100", "0"),
                5,
                Arrays.asList(
                        new LadderLevel(Arrays.asList(bar(), step(), bar(), emptyStep(), bar())),
                        new LadderLevel(Arrays.asList(bar(), emptyStep(), bar(), step(), bar())),
                        new LadderLevel(Arrays.asList(bar(), emptyStep(), bar(), emptyStep(), bar())),
                        new LadderLevel(Arrays.asList(bar(), step(), bar(), emptyStep(), bar())),
                        new LadderLevel(Arrays.asList(bar(), emptyStep(), bar(), step(), bar()))));

        ladder.print(new PrintWriter(System.out));
        assertThat(ladder.startFrom("nio")).isEqualTo("100");
        assertThat(ladder.startFrom("hoon")).isEqualTo("0");
        assertThat(ladder.startFrom("mit")).isEqualTo("1000");
    }

}