package nextstep.ladder.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MembersTest {
    private Members members;

    @BeforeEach
    private void before() {
        members = new Members("poni", "mouse", "peace");
    }

    @Test
    void 생성_비교() {
        Members targetMembers = new Members("poni,mouse,peace");
        assertThat(targetMembers).isEqualTo(members);
    }

    @Test
    void 건수_비교() {
        assertThat(members.countOfMember()).isEqualTo(3);
    }

    @Test
    void 참가자명단_미입력() {
        assertThatThrownBy(() -> {
            new Members("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
