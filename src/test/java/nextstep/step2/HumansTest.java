package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HumansTest {

    @Test
    void 문자열이_들어오면_쉼표로_나누어_사람_객체들을_만든다() {
        String names = "pobi, honux, crong, jk";
        Humans humans = new Humans(names);

        Assertions.assertEquals(4, humans.getHumanList().size());
        Assertions.assertEquals("pobi", humans.getHumanList().get(0).getName());
        Assertions.assertEquals("honux", humans.getHumanList().get(1).getName());
        Assertions.assertEquals("crong", humans.getHumanList().get(2).getName());
        Assertions.assertEquals("jk", humans.getHumanList().get(3).getName());
    }
}
