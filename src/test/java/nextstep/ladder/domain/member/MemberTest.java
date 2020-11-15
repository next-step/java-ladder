package nextstep.ladder.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 참여자 테스트")
public class MemberTest {
    @DisplayName("참여자 이름으로 생성")
    @Test
    public void createMemberWithName() {
        Member member = Member.of("name");

        String name = member.getName();

        assertThat(name).isEqualTo("name");
    }

    @DisplayName("0자 이하 또는 6자 이상으로 참여자 생성")
    @ParameterizedTest
    @MethodSource("getInvalidMemberNames")
    public void createMemberWithInvalidName(String invalidName) {
        assertThatThrownBy(() -> {
            Member.of(invalidName);
        }).isInstanceOf(InvalidMemberNameException.class)
                .hasMessageContaining("참여자 이름은 1자 이상 5자 이하로 입력해주세요.");
    }

    static Stream<String> getInvalidMemberNames() {
        return Stream.of("", "123456");
    }
}