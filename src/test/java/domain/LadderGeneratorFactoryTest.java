package domain;

import org.junit.Test;

public class LadderGeneratorFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void 입력한_난이도가_올바르지_않으면_Exception() {
        LadderGeneratorFactory.create("쉬움");
    }
}