package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ResultTagGroupTest {


    @Test
    public void 중복체크안함() {
        List<NameTag> nameTags = new ArrayList<>();
        NameTag nameTag = NameTag.of("crox");
        nameTags.add(nameTag);
        nameTags.add(nameTag);
    }

    @Test
    public void getName() {
        List<NameTag> nameTags = new ArrayList<>();
        NameTag nameTag = NameTag.of("crox");
        nameTags.add(nameTag);
        nameTags.add(nameTag);
        ResultTagGroup resultTagGroup = ResultTagGroup.of(nameTags);
        assertThat(resultTagGroup.getName(0)).isEqualTo("crox");
    }
}