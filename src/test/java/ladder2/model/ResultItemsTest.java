package ladder2.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultItemsTest {
    public static final ResultItems DEFAULT_RESULT_ITEMS = ResultItems.fromComma("꽝,5000,꽝,3000");

    @Test
    public void 생성_콤마() {
        assertThat(DEFAULT_RESULT_ITEMS).isNotNull();
    }

    @Test
    public void N번째_결과_조회() {
        assertThat(DEFAULT_RESULT_ITEMS.match(1)).isEqualTo(ResultItem.from("5000"));
    }
}