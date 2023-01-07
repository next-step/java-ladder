package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Members;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void ladderSizeTest(){
        Members members = new Members("a,b,c,d,e");
        Height height = new Height(5);

        Ladder ladder = new Ladder(members, height);
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(4);
    }
}
