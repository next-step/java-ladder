package me.namuhuchutong.ladder;

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
        //given
        int ladderHeight = 5;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(given, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리 높이는 자연수만 입력할 수 있고 최대 10까지 허용한다.")
    @Test
    void ladder_height_only_allows_integer_and_its_maximum_is_10() {
        //given
        String given = "a,b,c,d";
        int ladderHeight = 11;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(given, ladderHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열과 최대 높이 10을 넘지 않는 경우 정상적으로 객체를 생성한다.")
    @Test
    void test() {
        //given
        String given = "a,b,c,d";
        int height = 5;

        //when
        UserInputInformation information = new UserInputInformation(given, height);

        //then
        assertThat(information.getInputNames()).isEqualTo(given);
        assertThat(information.getLadderHeight()).isEqualTo(height);
    }
}
