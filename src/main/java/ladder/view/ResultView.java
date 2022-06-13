package ladder.view;

import ladder.domain.LadderLine;
import ladder.domain.User;

import java.util.List;

public class ResultView {

    public static void printLadder(List<String> strings, List<LadderLine> lines) {
        System.out.println(strings);
//        lines.forEach(line -> System.out.println(line.drawLine()));
    }

    public static void printResult(String searchName, List<User> users, List<String> resultList) {
        System.out.println("실행결과");

        if ("all".equalsIgnoreCase(searchName)) {
            for (User user : users) {
                System.out.println(user.getName() + " : " + resultList.get(user.getPosition()));
            }
            return;
        }

        User findUser = users.stream().filter(user -> searchName.equals(user.getName()))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("없는 사용자 입니다."));

        int position = findUser.getPosition();
        System.out.println(resultList.get(position));
    }

    public static void printLadder(List<String> drawUserList, List<LadderLine> lines, List<String> resultList) {
        System.out.println(drawUserList);

    }
}
