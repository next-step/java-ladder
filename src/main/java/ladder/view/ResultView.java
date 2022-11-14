package ladder.view;

import ladder.model.*;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    Scanner sc = new Scanner(System.in);
    public void printLadderResult(Users users, Ladder ladder, List<String> results) {
        System.out.println("사다리 결과");
        System.out.println();
        printUsers(users);
        printLadder(ladder);
        printResults(results);
        System.out.println();
    }

    public void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    private void printUsers(Users users) {
        users.stream()
                .forEach(user -> System.out.printf("%-6s", user.getName()));
        System.out.println();
    }

    private void printResults(List<String> results) {
        results.forEach(result -> System.out.printf("%-6s", result));
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        ladder.stream()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        System.out.print("|");
        for (int i = 0; i < line.size() - 1; ++i) {
            if (line.get(i) == Direction.RIGHT) {
                System.out.print("-----");
            } else {
                System.out.print("     ");
            }

            System.out.print("|");
        }
        System.out.println();
    }

    public void printGameResult(LadderGame ladderGame) {
        System.out.println("실행 결과");
        ladderGame.getUsers()
                .stream()
                .map(User::getName)
                .forEach(name -> System.out.println(name + " : " + ladderGame.getResult(name)));
    }

    public String inputNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        String string = sc.nextLine();
        System.out.println();
        return string;
    }
}
