package ladder.model.participant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NamesTest {
    @Test
    public void 참가자가_존재하는지_확인할_수_있다() throws Exception {
        //given
        Name test1 = new Name("test1");
        Name test2 = new Name("test2");
        Name test3 = new Name("test3");

        Names names = Names.of(test1, test2);

        //when, then
        assertTrue(names.contains(test1));
        assertTrue(names.contains(test2));
        assertFalse(names.contains(test3));
    }

}