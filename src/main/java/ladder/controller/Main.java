package ladder.controller;

import ladder.domain.LadderGame;
import ladder.util.InputUtil;

public class Main {
    public static void main(String[] args) {

        String names = InputUtil.returnString("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String resultValue = InputUtil.returnString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        int ladderHeight = InputUtil.returnInteger("최대 사다리 높이는 몇 개인가요?");

        LadderGame ladderGame = LadderGame.of(names, ladderHeight);
        ladderGame.game(resultValue);
    }
}
