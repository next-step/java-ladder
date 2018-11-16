package view;

import domain.Player;
import org.junit.Test;
import utils.StringUtils;

import java.util.List;

public class ResultViewTest {


    @Test
    public void printNames() {

        String names = "test1,test2,test3,test4";
        List<Player> players = StringUtils.joinPlayer(StringUtils.splitDelemeter(names));
        ResultView.printNames(players);
    }

}