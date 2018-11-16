package utils;

import org.junit.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StringUtilsTest {


    @Test
    public void getReplace() {
        String test = new String(new char[5]).replace(StringUtils.NULL_CHAR, "s");
        assertThat(test).isEqualTo("sssss");
    }
}