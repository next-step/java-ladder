package nextstep.ladder.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("참여자 이름 테스트")
public class MemberNameTest {
    @DisplayName("참여자 이름 생성")
    @Test
    public void createMemberName() {
        MemberName memberName = MemberName.of("pobi");

        String name = memberName.getName();

        assertThat(name).isEqualTo("pobi");
    }

    @DisplayName("0자 이하 또는 6자 이상으로 참여자 이름 생성")
    @ParameterizedTest
    @MethodSource("getInvalidMemberNames")
    public void createInvalidMemberName(String invalidName) {
        assertThatThrownBy(() -> {
            MemberName.of(invalidName);
        }).isInstanceOf(InvalidMemberNameException.class)
                .hasMessageContaining("참여자 이름은 1자 이상 5자 이하로 입력해주세요.");
    }

    static Stream<String> getInvalidMemberNames() {
        return Stream.of("", "123456");
    }

    @DisplayName("참여자 이름 동등 비교")
    @Test
    public void equalsMemberName() {
        assertThat(MemberName.of("pobi")).isEqualTo(MemberName.of("pobi"));
    }
}