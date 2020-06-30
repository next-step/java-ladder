
package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 게임 참여자 테스트")
public class MemberTest {

    @DisplayName("참여자 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "taeg", "yong"})
    public void createMemberTests(final String name) {
        assertThatCode(() -> Member.create(name)).doesNotThrowAnyException();
    }

    @DisplayName("참여자 생성 테스트 - 5자 글자 이상")
    @ParameterizedTest
    @ValueSource(strings = {"yongjin"})
    public void createMemberAbnormalTests(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Member.create(name))
                .withMessageContaining("사다리 게임에 참여하는 사람의 이름은 최대 5 글자 입니다.");
    }

    @DisplayName("참여자 생성 테스트 - 빈공백")
    @ParameterizedTest
    @NullAndEmptySource
    public void createMemberByNullAndEmptyNameTests(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Member.create(name))
                .withMessageContaining("사다리 게임에 참여하는 사람의 이름은 빈 공백이 될 수 없습니다.");
    }
}