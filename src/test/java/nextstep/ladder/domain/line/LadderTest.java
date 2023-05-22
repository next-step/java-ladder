package nextstep.ladder.domain.line;


import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    @Test
    public void Ladder_생성테스트() {
        //given
        List<List<Boolean>> lineList = new ArrayList<>();
        lineList.add(new ArrayList<>(Arrays.asList(true, false, true)));
        lineList.add(new ArrayList<>(Arrays.asList(true, false, true)));
        Users users = new Users();
        users.add(new User("A"));
        users.add(new User("B"));
        users.add(new User("C"));

        //when
        Ladder ladder = new Ladder(new TestLineGenerator(), new LadderHeight(2), users);

        //then
        assertThat(ladder).isEqualTo(lineList);
    }

}