package nextstep.ladder;

import nextstep.ladder.domain.InputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    void 참가자_이름설정_길이_테스트() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> {
            inputView.nameLengthValidate(Arrays.asList(""));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최대 5글자 최소1글자 입니다.");
    }

    @Test
    void 참가자_이름설정_테스트() {
        InputView inputView = new InputView();
        assertThat(inputView.inputToUsers("test1,test2")).containsExactly("test1", "test2");
    }
}
