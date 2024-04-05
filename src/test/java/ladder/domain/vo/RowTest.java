package ladder.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RowTest {

    @Test
    @DisplayName("열 생성 테스트")
    void rowTest(){
        final Row rowAfterTrue = new Row(()-> Boolean.TRUE, Boolean.TRUE);
        final Row rowAfterFalse = new Row(()-> Boolean.FALSE, Boolean.TRUE);

        assertThat(rowAfterTrue.bridgeExist()).isFalse();
        assertThat(rowAfterFalse.bridgeExist()).isTrue();
    }

    @Test
    @DisplayName("여러개의 열 생성 테스트")
    void rowsTest(){
        Rows rows = new Rows(5);

        assertThat(rows.rows()).hasSize(5);

        if(rows.rows().get(0).bridgeExist())
            assertThat(rows.rows().get(1).bridgeExist()).isFalse();

    }
}
