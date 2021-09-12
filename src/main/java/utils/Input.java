package utils;

import domain.Number;
import domain.User;
import domain.Users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

	private static final String REGEX_OF_USERS = ",";
	private Scanner scanner;

	public Input() {
		this.scanner = new Scanner(System.in);
	}

	public Users saveUsers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		String stringOfUsers = scanner.next();
		return new Users(Arrays.stream(stringOfUsers.split(REGEX_OF_USERS)).map(User::new)
						.collect(Collectors.toList()));
	}

	public Number saveLadderCount() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return new Number(scanner.nextInt());
	}
}
