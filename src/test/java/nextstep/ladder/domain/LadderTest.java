package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리 생성")
    void initLadder() {
        String names = "java,study,game";
        InputUsers inputUsers = new InputUsers(names);
        Height height = new Height(3);
        Users users = Users.createUsers(inputUsers);

        Ladder ladder = Ladder.initLadder(users, height);

        assertThat(ladder.getLines().size()).isEqualTo(3);
    }



}
