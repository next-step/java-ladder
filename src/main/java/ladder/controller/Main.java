package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.util.InputUtil;
import ladder.view.PrintResult;

public class Main {
    public static void main(String[] args) {

        String names = InputUtil.returnString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int ladderHeight = InputUtil.returnInteger("최대 사다리 높이는 몇 개인가요?");
        LadderGame ladderGame = new LadderGame(names, ladderHeight);
        ladderGame.game();
    }
}
