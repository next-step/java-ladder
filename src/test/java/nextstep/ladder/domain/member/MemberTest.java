package nextstep.ladder.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 참여자 테스트")
public class MemberTest {
    @DisplayName("참여자 이름으로 생성")
    @Test
    public void createMemberWithName() {
        Member member = Member.of("name", 0);

        String name = member.getName();

        assertThat(name).isEqualTo("name");
    }

    @DisplayName("참여자 위치")
    @Test
    public void getMemberPosition() {
        Member member = Member.of("name", 1);

        int position = member.getPosition();

        assertThat(position).isEqualTo(1);
    }

    @DisplayName("참여자 이름이 맞는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"name:true", "name2:false"}, delimiter = ':')
    public void hasName(String name, boolean expectedResult) {
        Member member = Member.of("name", 0);

        boolean hasName = member.hasName(MemberName.of(name));

        assertThat(hasName).isEqualTo(expectedResult);
    }
}