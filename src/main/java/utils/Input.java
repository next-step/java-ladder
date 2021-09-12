package utils;

import domain.User;

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

	public List<User> saveUsers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		String stringOfUsers = scanner.next();
		return Arrays.stream(stringOfUsers.split(REGEX_OF_USERS)).map(User::new)
						.collect(Collectors.toList());
	}
}
