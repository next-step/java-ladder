package ladder.domain.vo;

import ladder.domain.factory.RowFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @Test
    @DisplayName("열 생성 테스트")
    void rowTest(){
        final Row bridgeTrueRow = new Row(true);
        final Row bridgeFalseRow = new Row(false);

        assertThat(bridgeTrueRow.bridgeExist()).isTrue();
        assertThat(bridgeFalseRow.bridgeExist()).isFalse();
    }

    @Test
    @DisplayName("여러개의 열 생성 테스트")
    void rowsTest(){
        Rows rows = RowFactory.createRandom(5);

        assertThat(rows.rows()).hasSize(5);

        if(rows.rows().get(0).bridgeExist())
            assertThat(rows.rows().get(1).bridgeExist()).isFalse();

    }
}
