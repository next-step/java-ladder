package ladder.model;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultItemTest {
    public static final ResultItem DEFAULT_RESULT_ITEM = ResultItem.from("3000");

    @Test
    public void 생성() {
        assertThat(DEFAULT_RESULT_ITEM).isNotNull();
    }

    @Test
    public void 결과_이름() {
        assertThat(DEFAULT_RESULT_ITEM.toString()).isEqualTo("3000");
    }
}