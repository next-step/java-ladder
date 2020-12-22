package ladder.domain;

import org.assertj.core.util.Maps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public abstract class LadderTest {

    protected Ladder ladder;

    protected List<String> members = Arrays.asList("nio", "hoon", "mit");
    protected List<String> results = Arrays.asList("10000", "5000", "0");

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
                        new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Step, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar)),
                        new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Step, LadderItem.Bar)),
                        new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar)),
                        new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Step, LadderItem.Bar, LadderItem.Empty, LadderItem.Bar)),
                        new LadderLevel(Arrays.asList(LadderItem.Bar, LadderItem.Empty, LadderItem.Bar, LadderItem.Step, LadderItem.Bar))));
    }


    @DisplayName("사디리높이가 1보다 작으면 exception 을 던진다")
    @Test
    void illegalHeight(){
        assertThatThrownBy( () -> new DefaultLadder(Arrays.asList("nio", "hoon", "mit"), Arrays.asList("0", "1000", "2000"), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

