package ladder.domain;

import ladder.domain.next.LadderLine;
import ladder.domain.next.NextLadder;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static ladder.domain.LevelItem.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

abstract class LadderTest {

    Ladder ladder;

    List<String> members = Arrays.asList("nio", "hoon", "mit");
    List<String> results = Arrays.asList("10000", "5000", "0");

    @DisplayName("참가자 이름을 입력하면 결과를 알려준다")
    @Test
    void startFrom(){
        assertThat(ladder.startFrom("nio")).isEqualTo(new LadderResult("5000"));
        assertThat(ladder.startFrom("hoon")).isEqualTo(new LadderResult("0"));
        assertThat(ladder.startFrom("mit")).isEqualTo(new LadderResult("10000"));
    }

    @DisplayName("참가자 전원의 결과를 알려준다")
    @Test
    void startAll(){
        Map<LadderMember, LadderResult> results = ladder.startAll();

        Map<LadderMember, LadderResult> expected = Maps.newHashMap(new LadderMember("nio"), new LadderResult("5000"));
        expected.put(new LadderMember("hoon"), new LadderResult("0"));
        expected.put(new LadderMember("mit"), new LadderResult("10000"));

        assertThat(results).containsExactlyEntriesOf(expected);
    }
}

class DefaultLadderTest extends LadderTest {

    @BeforeEach
    void setUp(){
        ladder = new DefaultLadder(
                members,
                results,
                Arrays.asList(
                        new LadderLevel(Arrays.asList(bar(), step(), bar(), emptyStep(), bar())),
                        new LadderLevel(Arrays.asList(bar(), emptyStep(), bar(), step(), bar())),
                        new LadderLevel(Arrays.asList(bar(), emptyStep(), bar(), emptyStep(), bar())),
                        new LadderLevel(Arrays.asList(bar(), step(), bar(), emptyStep(), bar())),
                        new LadderLevel(Arrays.asList(bar(), emptyStep(), bar(), step(), bar()))));
    }


    @DisplayName("사디리높이가 1보다 작으면 exception 을 던진다")
    @Test
    void illegalHeight(){
        assertThatThrownBy( () -> new DefaultLadder(Arrays.asList("nio", "hoon", "mit"), Arrays.asList("0", "1000", "2000"), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

class NextLadderTest extends LadderTest {

    @BeforeEach
    void setUp(){
        List<LadderLine> lines = Arrays.asList(
                LadderLine.builder().first(true).next(false).last().build(),
                LadderLine.builder().first(false).next(true).last().build(),
                LadderLine.builder().first(false).next(false).last().build(),
                LadderLine.builder().first(true).next(false).last().build(),
                LadderLine.builder().first(false).next(true).last().build()
        );

        ladder = new NextLadder(
                members,
                results,
                lines
        );
    }

}