package domain;

import org.junit.Test;
import utils.StringUtils;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NameTagTest {
    @Test
    public void 플레이어만들기내부로직테스트() {
        String names = "stron,box,test,kkk,sdfa";
        List<NameTag> nameTags = StringUtils.makeNameTag(names);
        String[] playerNames = names.split(",");
        for(String playerName : playerNames){
            NameTag nameTag =  NameTag.of(playerName);
        }
        assertThat("kkk").isEqualTo(playerNames[3]);
    }

    @Test
    public void 플레이어만들기테스트() {
        String names = "stron,box,test,kkk,sdfa";
        List<NameTag> nameTags = StringUtils.makeNameTag(names);
        assertThat(nameTags.get(3)).isEqualTo(NameTag.of("kkk"));

    }


    @Test(expected = RuntimeException.class)
    public void 글자수테스트() {
        String names = "stronxxx,box,test,kkk,sdfa";
        List<NameTag> nameTags = StringUtils.makeNameTag(names);

    }
}