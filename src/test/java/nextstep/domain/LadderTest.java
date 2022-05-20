package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    @Test
    void 실행결과개수와_유저수가_다를_경우() {
        assertThatThrownBy(() -> {
            new Ladder(2, new LadderHeight(5), new LadderResult(Arrays.asList("1","2","3")));
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void 유저리스트에_유저가_존재하지_않을경우() {
        assertThatThrownBy(() -> {
            Ladder ladder = new Ladder(2, new LadderHeight(5), new LadderResult(Arrays.asList("1","2","3")));
            ladder.find(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저결과_확인() {
        LadderResult ladderResult =new LadderResult(Arrays.asList("1","2"));
        Ladder ladder = new Ladder(2, new LadderHeight(5),ladderResult);
        ladderResult.addResultIndex(0);
        ladderResult.addResultIndex(6);
        Users users = new Users(Arrays.asList(new User("soon"), new User("test")));
        assertThat(ladder.find(users.findUsernameIndex("soon"))).isEqualTo("1");
    }

}