package nextstep.step2.view;

import nextstep.step2.vo.Names;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    @Test
    void printNamesTest() {
        String expect = "miz    mi     k      mizm   mizmm  ";
        Names names = Names.createWithString("miz,mi,k,mizm,mizmm");
        OutputView outputView = new OutputView();

        assertThat(outputView.namesToPrintString(names)).isEqualTo(expect);
    }

}
