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
    void user_name_input_only_allows_strings_and_comma(String given) {
        int ladderHeight = 5;

        assertThatThrownBy(() -> new UserInputInformation(given, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 높이는 자연수만 입력할 수 있고 최대 10까지 허용한다.")
    @Test
    void ladder_height_only_allows_integer_and_its_maximum_is_10() {
        String given = "a,b,c,d";
        int ladderHeight = 11;

        assertThatThrownBy(() -> new UserInputInformation(given, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열과 최대 높이 10을 넘지 않는 경우 정상적으로 객체를 생성한다.")
    @Test
    void if_strings_with_comma_and_number_not_exceed_10_will_create_object() {
        String given = "a,b,c,d";
        int height = 5;
        String expectedName = "a,b,c,d";
        int expectedHeight = 5;

        UserInputInformation information = new UserInputInformation(given, height);
        String actualName = information.getInputNames();
        int actualHeight = information.getLadderHeight();

        assertThat(actualName).isEqualTo(expectedName);
        assertThat(actualHeight).isEqualTo(expectedHeight);
    }
}
