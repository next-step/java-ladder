package nextstep.ladder.view;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.UserLadderResult;

import java.util.*;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<User> getUserNames() {
        while (true) {
            try {
                return makeUsers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<User> makeUsers() {
        String names;
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names = SCANNER.next();
        String[] userNameList = names.split(",");
        List<User> users = new ArrayList<>();

        IntStream.range(0, userNameList.length).forEach(index -> users.add(new User(userNameList[index], index)));

        return users;
    }

    public static List<Result> getResults() {
        while (true) {
            try {
                return makeResults();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printResults(UserLadderResult userLadderResult) {
        while (true) {
            try {
                System.out.println("결과를 보고 싶은 사람은?");

                String userName = SCANNER.next();
                ResultView.printUserResult(userLadderResult, userName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

 
    private static List<Result> makeResults() {
        String resultInput;
        System.out.println("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        resultInput = SCANNER.next();
        String[] resultList = resultInput.split(",");
        List<Result> results = new ArrayList<>();

        Arrays.stream(resultList).forEach(result -> results.add(new Result(result)));

        return results;
    }

    public static int ladderHeight() {
        int number;
        while (true) {
            try {
                System.out.println("최대 사다리 높이는 몇 개 인가요?");
                number = SCANNER.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값을 입력하였습니다");
                SCANNER.next();
            }
        }
    }

}
