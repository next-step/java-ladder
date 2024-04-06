package ladder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ladder.model.Line.createOneLine;
import static org.assertj.core.api.Assertions.assertThat;

public class NameListTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "이름, 민수"})
    @DisplayName("이름이 영어가 아닌 경우 에러")
    void name_is_english(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameList(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"himyname,ischjy"})
    @DisplayName("이름 길이가 5 초과인 경우 에러")
    void check_name_length(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameList(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"judy ,judy"})
    @DisplayName("이름 중복시 에러")
    void check_dup_name(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new NameList(input);
        });
    }

    @Test
    @DisplayName("list 범위를 넘은 index 입력 시 swap 에러 발생")
    void check_swap() {
        NameList nameList = new NameList("anna, pony, ando");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            nameList.swapPoints(2);
        });
    }
    @Test
    @DisplayName("list 범위를 넘지 않은 index 입력 시 정상 swap")
    void check_swap_correct() {
        NameList nameList = new NameList("anna, pony, ando");

        NameList nameList1 = nameList.swapPoints(1);
        NameList nameList2 = new NameList("anna, ando, pony");
        assertThat(nameList1.getNameList()).isEqualTo(nameList2.getNameList());

    }

}
