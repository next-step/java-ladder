package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("사다리 높이 입력 성공 테스트")
    void 사다리_높이_입력_성공_테스트() {
        List<String> personList = Arrays.asList("pobi", "hj", "seul", "hj2");
        Ladder ladder = Ladder.create(3, personList.size());
        Users users = Users.valueOf(personList);
        WinningItems winningItems = new WinningItems(Arrays.asList("1000", "꽝", "꽝", "2000"));

        Result result = new Result(users, ladder, winningItems);
        result.calculateLadderResult();

        assertThat(result.getResult().size()).isEqualTo(users.getNames().size());
        assertThat(result.getResult().size()).isEqualTo(winningItems.getWinningItems().size());
    }
}
