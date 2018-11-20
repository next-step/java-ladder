package utils;

import domain.NameTag;
import org.junit.Test;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class StringUtilsTest {


    @Test
    public void getReplace() {
        String test = new String(new char[5]).replace(StringUtils.NULL_CHAR, "s");
        assertThat(test).isEqualTo("sssss");
    }

    @Test
    public void makeNameTag() {
        String names ="cronx,frost";
        List<NameTag> nameTags =  StringUtils.makeNameTag(names);
        nameTags.contains(NameTag.of("cronx"));

    }
}