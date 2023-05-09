package ladder.view;

import ladder.util.InputUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("사람 이름 입력 테스트")
    void test_person_name(){
        InputUtil.testInputStream("crong");
        assertThat(InputView.setNames()).contains("crong");
    }

    @Test
    @DisplayName("사람 이름 입력 테스트 (구분자 사용)")
    void test_person_name_with_comma(){
        InputUtil.testInputStream("crong, honox");
        assertThat(InputView.setNames())
                .contains("crong")
                .contains("honox");
    }

    @Test
    @DisplayName("사람 이름 최대 5글자 허용 여부")
    void test_person_name_length_check(){
        assertThat(InputView.lengthValidate("crong")).isEqualTo(true);
    }

    @Test
    @DisplayName("사람 이름 최대 5글자 이상시 Exception 발생")
    void test_person_name_length_check_with_exception(){
        assertThatThrownBy(
                () -> InputView.lengthValidate("crong123"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사람에 이름을 최대5글자까지 부여할 수 있습니다");
    }


    @Test
    @DisplayName("사람 이름 다중 입력 테스트")
    void test_person_name_multiple_to_array(){
        InputUtil.testInputStream("crong, honox, pobi");
        assertThat(InputView.enterPlayers())
                .contains("crong")
                .contains("honox")
                .contains("pobi");
    }


    @Test
    @DisplayName("사다리 높이 입력 테스트")
    void test_ladder_value(){
        InputUtil.testInputStream("5");
        assertThat(InputView.enterHeight()).isEqualTo(5);
    }
}