package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultRecordTest {
    private final ResultOfPlayer resultOfPlayer = new ResultOfPlayer("a,", "꽝");

    @Test
    void add() {
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.add(resultOfPlayer);

        ResultOfPlayer result = resultRecord.getResultOfPlayers().get(0);
        assertThat(result).isEqualTo(result);
    }

    @Test
    void find() {
        ResultRecord resultRecord = new ResultRecord();
        resultRecord.add(resultOfPlayer);

        assertThatThrownBy(() -> resultRecord.find("b"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("일치하는 이름이 없습니다.");
    }
}
