package domain;


import org.junit.Test;
import util.StringUtil;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTagTest {

    @Test
    public void 사람목록만들기() {
        String names = "pobi,honux,crong,jk";
        List<NameTag> nameTagGroup = StringUtil.makeNameTags(names);
        assertThat(3).isEqualTo(nameTagGroup.indexOf(NameTag.of("jk")));
    }

    @Test
    public void 결과보고싶은사람() {
        String names = "pobi,honux,crong,jk";
        List<NameTag> nameTagGroup = StringUtil.makeNameTags(names);
        assertThat(nameTagGroup.indexOf(NameTag.of("pobi"))).isEqualTo(0);
    }

    @Test
    public void 실행결과() {
        String results = "꽝,5000,꽝,3000";
        List<NameTag> resultTagGroup = StringUtil.makeNameTags(results);
        assertThat(resultTagGroup.get(3)).isEqualTo(NameTag.of("3000"));
    }

    @Test
    public void 이름길이테스트() {
        NameTag.of("123456");
    }
}