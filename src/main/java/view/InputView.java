package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hspark on 16/11/2018.
 */
public class InputView {
	public static List<String> inputGamers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		Scanner scanner = new Scanner(System.in);
		return Arrays.asList(scanner.nextLine().trim().split(","));
	}

	public static List<String> inputRewards() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		Scanner scanner = new Scanner(System.in);
		return Arrays.asList(scanner.nextLine().trim().split(","));
	}

	public static String inputLadderLevel() {
		System.out.println("실행할 사다리의 난이도는?");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static String inputGamerNameForReward() {
		System.out.println("결과를 보고 싶은 사람은?");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
