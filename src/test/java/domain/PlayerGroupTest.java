package domain;

import org.junit.Before;
import org.junit.Test;
import utils.StringUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class PlayerGroupTest {
    PlayerGroup playerGroup;

    @Before
    public void setUp() {
        String names = "stron,box,test,kkk,sdfa";
        playerGroup = new PlayerGroup(StringUtils.joinPlayer(StringUtils.splitDelemeter(names)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복이름넣기() {
        String names = "stron,stron,test,kkk,sdfa";
        playerGroup = new PlayerGroup(StringUtils.joinPlayer(StringUtils.splitDelemeter(names)));
    }

    @Test
    public void getNameIndex() {
        assertThat(playerGroup.getNameIndex("box")).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 없는이름찾기테스트() {
        playerGroup.getNameIndex("box111");
    }

    @Test
    public void getName() {
        assertThat(playerGroup.getName(2).trim()).isEqualTo("test");
    }

    @Test
    public void getSize() {
        assertThat(playerGroup.getSize()).isEqualTo(5);
    }

}