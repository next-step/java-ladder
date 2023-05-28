package ladder.domain.ladder;

import ladder.domain.WinningCategories;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningCategoriesTest {

    @Test
    @DisplayName("실행결과를 입력받아 결과그룹 객체를 생성할 수 있다.")
    void create_ReceiveResultList_ContainsExactly() {
        String input = "꽝,5000,꽝,5000";

        WinningCategories winningCategories = new WinningCategories(input);
        List<String> resultNames = winningCategories.getResultNames();

        Assertions.assertThat(resultNames)
                .containsExactly("꽝", "5000", "꽝", "5000")
                .hasSize(4);
    }
}
