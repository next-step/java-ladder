package nextstep.ladder;

import nextstep.ladder.domain.Members;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MembersTest {

    @Test
    @DisplayName("멤버 생성 테스트")
    void membersSizeTest(){
        Members members = new Members("11,22,33,44");
        assertThat(members.getSize()).isEqualTo(4);
    }
}
