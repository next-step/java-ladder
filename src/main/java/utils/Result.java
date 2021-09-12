package utils;

import domain.Line;
import domain.Users;

import java.util.List;

public class Result {

	private static final String IS_WIDTH = "-----";
	private static final String NOT_IS_WIDTH = "     ";
	private static final String VERTICAL = "|";

	public void viewUsers(Users users) {
		System.out.println(users.toString());
	}

	public void viewLadder(List<Line> lines) {
		lines.forEach(System.out::println);
	}
}
