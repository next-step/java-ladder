package nextstep.ladder.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 참여자들 테스트")
public class MembersTest {
    @DisplayName("사다리 참여자들 생성")
    @Test
    public void createMembers() {
        Members members = Members.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        int memberCount = members.getCount();

        assertThat(memberCount).isEqualTo(4);
    }

    @DisplayName("2 미만의 참여자 생성")
    @ParameterizedTest
    @MethodSource("getMemberNames")
    public void createLineWithInvalidPersonCount(List<String> memberNames) {
        assertThatThrownBy(() -> {
            Members.of(memberNames);
        }).isInstanceOf(InvalidMemberCountException.class)
                .hasMessageContaining("2명 이상의 참여자로만 사다리 생성이 가능합니다.");
    }

    static Stream<List<String>> getMemberNames() {
        return Stream.of(
                Collections.singletonList("pobi"),
                Collections.emptyList()
        );
    }

    @DisplayName("멤버의 위치 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"pobi:0", "jk:3"}, delimiter = ':')
    public void getMemberIndex(String name, int expectedPosition) {
        Members members = Members.of(Arrays.asList("pobi", "honux", "crong", "jk"));

        int position = members.findMember(MemberName.of(name));

        assertThat(position).isEqualTo(expectedPosition);
    }

    @DisplayName("없는 멤버 위치 가져오기")
    @Test
    public void getInvalidMemberIndex() {
        Members members = Members.of(Arrays.asList("pobi", "honux", "crong", "jk"));
        assertThatThrownBy(() -> {
            members.findMember(MemberName.of("no"));
        }).isInstanceOf(MemberNotFoundException.class)
                .hasMessageContaining("해당 멤버를 찾을 수 없습니다.");

    }
}