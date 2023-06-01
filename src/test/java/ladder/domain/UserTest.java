package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladder.DoNotCreateUser;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void 참여자는_최소_2이상이어야_한다() {
        assertThatThrownBy(() -> {
            new Users("yeju");
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 사람_이름은_쉼표를_기준으로_구분한다() {
        assertAll(() -> {
            assertThat(new Users("yeju,mimi,aiai"));
            assertThatThrownBy(() -> new Users("yeju,miaisi,pipi"))
                    .isInstanceOf(DoNotCreateUser.class);
        });
    }

    @Test
    void 사다리_게임에_참여하는_사람에_이름을_최대5글자까지_부여할_수_있다() {
        assertAll(() -> {
            assertThat(new User("yeju"));
            assertThatThrownBy(() -> new User("simyeju"))
                    .isInstanceOf(DoNotCreateUser.class);
        });
    }
}
