package ladder.model.game;

import ladder.model.*;
import ladder.model.stringas.StringAsHeight;
import ladder.model.stringas.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.*;

public class LadderGameApp {

    public static void main(String[] args) {
        try {
            Players players = new Players(InputView.getStringValue("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"));
            Height height = new StringAsHeight(InputView.getStringValue("최대 사다리 높이는 몇 개인가요?")).get();
            //LadderGame game = new LadderGame(players, height);
            //List<Line> lineList = game.play();
            //ResultView.printResult(players, lineList);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
