package view;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    @Test
    public void 모두_연결된_문자열_출력() {
        assertThat(OutputView.getLineText(Arrays.asList(true, true, true)))
                .isEqualTo(OutputView.LINE + OutputView.CONNECT
                        + OutputView.LINE + OutputView.CONNECT
                        + OutputView.LINE + OutputView.CONNECT + OutputView.LINE);
    }
}