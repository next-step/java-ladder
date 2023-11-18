package me.namuhuchutong.ladder;

import me.namuhuchutong.ladder.dto.UserInputInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class UserInputInformationTest {

    @DisplayName("사용자 이름 입력은 문자열과 (,)만 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "@#,adf#@,adf32,3sdd",
            "d2vd,f3gs,@$#d,,"
    })
    void user_name_input_only_allows_strings_and_comma(String givenNames) {
        int ladderHeight = 5;
        String givenResults = "a,b,c,d";

        assertThatThrownBy(() -> new UserInputInformation(givenNames, givenResults, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 높이는 자연수만 입력할 수 있고 최대 10까지 허용한다.")
    @Test
    void ladder_height_only_allows_integer_and_its_maximum_is_10() {
        String givenNames = "a,b,c,d";
        String givenResults = "a,b,c,d";
        int ladderHeight = 11;

        assertThatThrownBy(() -> new UserInputInformation(givenNames, givenResults, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열과 최대 높이 10을 넘지 않는 경우 정상적으로 객체를 생성한다.")
    @Test
    void if_strings_with_comma_and_number_not_exceed_10_will_create_object() {
        String givenNames = "a,b,c,d";
        String givenResults = "a,b,c,d";
        int givenHeight = 5;
        String expectedName = "a,b,c,d";
        int expectedHeight = 5;

        UserInputInformation information = new UserInputInformation(givenNames, givenResults, givenHeight);
        String actualName = information.getInputNames();
        int actualHeight = information.getLadderHeight();

        assertThat(actualName).isEqualTo(expectedName);
        assertThat(actualHeight).isEqualTo(expectedHeight);
    }

    @DisplayName("사용자 수와 결과 수가 동일하지 않다면 예외가 발생한다.")
    @Test
    void throw_exception_when_names_and_results_length_is_not_same() {
        String givenInput = "a,b,c,d";
        String givenResults = "a,b,c";
        int givenHeight = 1;

        assertThatThrownBy(() -> new UserInputInformation(givenInput, givenResults, givenHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
