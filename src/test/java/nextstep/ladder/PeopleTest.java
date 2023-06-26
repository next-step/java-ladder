package nextstep.ladder;

import nextstep.ladder.domain.People;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PeopleTest {

    @Test
    @DisplayName("사람 생성 테스트")
    public void makePeople() {
        People java = new People("java");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new People("isover5"))
                .withMessage("사람의 이름은 5를 초과할 수 없습니다.")
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(java).isInstanceOf(People.class);
    }
}
