package domain.ladder;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void 포인트생성_개수() {
        assertThat(asList(Boolean.FALSE, Boolean.TRUE)).hasSize(2);
    }
}