package nextstep.ladder.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 참여자 테스트")
public class MemberTest {
    @DisplayName("참여자 이름으로 생성")
    @Test
    public void createMemberWithName() {
        Member member = Member.of("name");

        String name = member.getName();

        assertThat(name).isEqualTo("name");
    }
}