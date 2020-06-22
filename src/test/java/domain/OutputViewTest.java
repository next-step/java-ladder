package domain;

import org.junit.jupiter.api.Test;
import view.OutputView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    @Test
    public void 이름은_5글자기준으로_여백을두어_출력한다() {
        String name = "abc";

        assertEquals(OutputView.get5SpaceText(name), " abc ");
    }

    @Test
    public void 다섯글자는_여백이_없다() {
        String name = "abcde";

        assertEquals(OutputView.get5SpaceText(name), "abcde");
    }

    @Test
    void 네글자는_끝에_여백을_둔다() {
        String name = "abcd";

        assertEquals(OutputView.get5SpaceText(name), "abcd ");

    }

    @Test
    void 두글자는_앞에_여백이_하나다() {
        String name = "ab";

        assertEquals(OutputView.get5SpaceText(name), " ab  ");
    }
}