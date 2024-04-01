package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntriesTest {

    @Test
    void 문자열이_들어오면_쉼표로_나누어_사람_객체들을_만든다() {
        String names = "pobi, honux, crong, jk";
        Entries entries = new Entries(names);

        Assertions.assertAll(
                () -> Assertions.assertEquals(4, entries.getHumanList().size()),
                () -> Assertions.assertEquals("pobi", entries.getHumanList().get(0).getName()),
                () -> Assertions.assertEquals("honux", entries.getHumanList().get(1).getName()),
                () -> Assertions.assertEquals("crong", entries.getHumanList().get(2).getName()),
                () -> Assertions.assertEquals("jk", entries.getHumanList().get(3).getName())
        );
    }
}
