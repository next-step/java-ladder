package view;

import domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {

    private final static String SPLITTER = ",";
    private static Scanner scanner;

    public static Players getNameOfParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
        scanner = new Scanner(System.in);
        List<String> names = splitStringToList(scanner.nextLine());

        List<Player> pariticipants = new ArrayList<>();
        for (String name : names) {
            pariticipants.add(new Player(name));
        }
        return new Players(pariticipants);
    }

    public static int getDepthOfLadders() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Level getLevelOfLadderGame() {
        System.out.println("실행할 사다리의 난이도는? (상, 중, 하 중 선택)");
        scanner = new Scanner(System.in);
        return Level.valueOf(scanner.nextLine());
    }

    public static Results getResultOfGame() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        scanner = new Scanner(System.in);

        List<String> inputs = splitStringToList(scanner.nextLine());
        List<Result> results = new ArrayList<>();
        for (String input : inputs) {
            results.add(new Result(input));
        }
        return new Results(results);
    }

    public static Player getPlayerToShowResult(Players players) {
        System.out.println("결과를 보고 싶은 사람은?");
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals(Player.ALL)) return new Player(Player.ALL);
        return players.find(input);
    }

    private static List<String> splitStringToList(String input) {
        return Arrays.stream(input.split(SPLITTER))
                        .collect(Collectors.toList());
    }
}
