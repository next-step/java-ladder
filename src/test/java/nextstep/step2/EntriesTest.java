package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntriesTest {

    @Test
    void 문자열이_들어오면_쉼표로_나누어_사람_객체들을_만든다() {
        String names = "pobi, honux, crong, jk";
        Entries entries = new Entries(names);

        Assertions.assertAll(
                () -> Assertions.assertEquals(4, entries.getParticipantList().size()),
                () -> Assertions.assertEquals("pobi", entries.getParticipantList().get(0).getName()),
                () -> Assertions.assertEquals("honux", entries.getParticipantList().get(1).getName()),
                () -> Assertions.assertEquals("crong", entries.getParticipantList().get(2).getName()),
                () -> Assertions.assertEquals("jk", entries.getParticipantList().get(3).getName())
        );
    }

    @Test
    void 동명이인이_있으면_에러가_발생한다() {
        String names = "pobi, honux, jk, jk";
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Entries(names));
    }
}
