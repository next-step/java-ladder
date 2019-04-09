package view;

import domain.Player;
import domain.Players;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static String SPLITTER = ",";

    public static Players getNameOfParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> names = Arrays.asList(splitNames(input));
        List<Player> pariticipants = new ArrayList<>();
        for (String name : names) {
            pariticipants.add(new Player(name));
        }
        return new Players(pariticipants);
    }

    public static int getDepthOfLadders() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        int depthOfLadders = scanner.nextInt();
        return depthOfLadders;
    }

    private static String[] splitNames(String input) {
        return input.split(SPLITTER);
    }
}
