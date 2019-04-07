package view;

import domain.Participants;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    public static Participants getNameOfParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Participants(Arrays.asList(splitNames(input)));
    }

    public static int getDepthOfLadders() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        int depthOfLadders = scanner.nextInt();
        return depthOfLadders;
    }

    private static String[] splitNames(String input) {
        return input.split(",");
    }
}
