package nextstep.ladder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import nextstep.ladder.domain.Person;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void 사람_이름을_최대5글자까지_부여할_수_있다() {
        assertThatThrownBy(() -> {
            new Person("long_name");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 최대 5글자까지 가능합니다.");
    }

    @Test
    public void 사람_이름은_빈_문자열일_수_없다() {
        assertThatThrownBy(() -> {
            new Person("");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("이름은 null 또는 빈 문자열일 수 없습니다.");
    }

}
