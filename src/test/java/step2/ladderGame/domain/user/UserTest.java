package step2.ladderGame.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class UserTest {

    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(strings = {"바나나", "파인애플", "감", "천도복숭아"})
    void create(String input) {
        assertThat(new User(input)).isInstanceOf(User.class);
    }

    @DisplayName("이름이 null이거나 빈값일 경우 에러발생")
    @ParameterizedTest
    @NullAndEmptySource
    void create_이름이_null이거나_빈값일_경우_에러발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new User(input);
        }).withMessageMatching("입력값이 없습니다.");
    }

    @DisplayName("이름이 1글자~5글자 사이가 아닐 경우 에러발생")
    @ParameterizedTest
    @ValueSource(strings = {"레인보우샤베트", "엄마는외계인", "쿠키앤크림치즈"})
    void create_이름이_1에서_5글자_사이가_아닐_경우_에러발생(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new User(input);
        }).withMessageMatching("이름은 1~5글자 사이로 입력해야 합니다.");
    }

    @DisplayName("입력한 이름 반환")
    @ParameterizedTest
    @ValueSource(strings = {"원숭이", "코끼리", "푸마", "불독"})
    void getName(String input) {
        assertThat(new User(input).getName()).isEqualTo(input);
    }

}
