package ladder.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@DisplayName("사다리 게임 참여자 복수 테스트")
class MembersTest {

    @DisplayName("참여자 생성 복수 테스트")
    @ParameterizedTest
    @MethodSource("createMembersCases")
    public void createMembersTests(String memberNames) {
        assertThatCode(() -> Members.create(memberNames)).doesNotThrowAnyException();
    }

    private static Stream<Arguments> createMembersCases() {
        return Stream.of(
            Arguments.of("yong,pobi"),
            Arguments.of("kim,lee,park,choi"),
            Arguments.of("jame,mike,paul,kate")
        );
    }

    @DisplayName("참여자 생성 복수 테스트 - 빈공백")
    @ParameterizedTest
    @NullAndEmptySource
    public void createMembersByNullAndEmptyNameTests(final String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Members.create(name))
            .withMessageContaining("사다리 게임에 참여하는 사람이 없습니다.");
    }
}