package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MembersTest {
    private Members members;

    @BeforeEach
    private void before() {
        members = Members.of("poni", "mouse", "peace");
    }

    @Test
    void 생성_비교() {
        Members targetMembers = Members.from("poni,mouse,peace");
        assertThat(targetMembers).isEqualTo(members);
    }

    @Test
    void 건수_비교() {
        assertThat(members.countOfMember()).isEqualTo(3);
    }

    @Test
    void 참가자명단_미입력시_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            Members.from("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 동일한_참가자_입력시_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            Members.from("pobi,mouse,pobi");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
