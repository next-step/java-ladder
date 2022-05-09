package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    @Test
    void 라인_겹치는거_없는지_확인() {
        new LadderLine(3, 2).getPoints()
                .forEach(p -> System.out.print(p+","));
        System.out.println();
    }
}