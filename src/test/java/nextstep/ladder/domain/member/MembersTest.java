package nextstep.ladder.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}