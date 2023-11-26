package nextstep.ladder.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 가로 선 출력기 테스트")
public class RowLinePrinterTest {

    @Test
    void generate() {
        System.out.println("generate : " + RowLinePrinter.generate());
    }
}
