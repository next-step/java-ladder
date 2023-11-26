package nextstep.ladder.common.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 세로 선 출력기 테스트")
public class ColumnPrinterTest {

    @Test
    void generate() {
        System.out.println("generate : " + ColumnPrinter.generate());
    }
}
