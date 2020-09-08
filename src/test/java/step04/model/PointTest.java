package step04.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointTest {

    @DisplayName("사다리의 구성요소 출력 테스트")
    @Test
    void getPrintableString() {
        // given & then
        System.out.println("가로줄 : " + Point.ROW.getPrintableString());
        System.out.println("세로줄 : " + Point.COLUMN.getPrintableString());
        System.out.println("공백(5칸) : " + Point.BLANK.getPrintableString() + "끝");
    }
}
