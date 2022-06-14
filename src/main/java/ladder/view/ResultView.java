package ladder.view;

import ladder.domain.LadderLine;
import ladder.domain.Point;
import ladder.domain.User;
import ladder.domain.Users;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLadder(Users drawUserList, List<LadderLine> ladderLine, List<String> resultList) {
        drawUserList.drawUserNames();
        System.out.println();

        for (LadderLine line : ladderLine) {
            line.draw();
            System.out.println();
        }

        resultList.forEach(System.out::print);
        System.out.print(" ");
    }

    public static void printResult(Map<String , Integer> ladderLine, String searchName) {
        System.out.println("실행결과");

        if ("all".equalsIgnoreCase(searchName)) {
            ladderLine.entrySet().forEach(System.out::println);
            return;
        }

        String key = ladderLine.keySet().stream().filter(name -> name.equals(searchName))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("없는 사용자 입니다."));

        System.out.println(String.format("%s의 값은 : %s"  , key, ladderLine.get(key)));
    }
}
