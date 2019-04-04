package ladder.view;

import org.junit.Test;

public class LadderInputViewTest {

    @Test
    public void 입력이름_정규식패턴_성공1() {
        LadderInputView.checkNamePattern("a,b,c,d,e");
    }

    @Test
    public void 입력이름_정규식패턴_성공2() {
        LadderInputView.checkNamePattern("  a,b,c,d,e  ");
    }

    @Test
    public void 입력이름_정규식패턴_성공3() {
        LadderInputView.checkNamePattern("aaaaa,b,c,d,e");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 입력이름_정규식패턴_실패1() {
        LadderInputView.checkNamePattern("a,b,");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 입력이름_정규식패턴_실패2() {
        LadderInputView.checkNamePattern(",b,c,d");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 입력이름_정규식패턴_실패3() {
        LadderInputView.checkNamePattern("aaaaaa,b,c,d");
    }
}