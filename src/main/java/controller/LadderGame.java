package controller;

import domain.Line;
import domain.Number;
import domain.Users;
import utils.Input;
import utils.Result;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

	private static final Integer INIT_NUMBER = 0;

	public static void main(String[] args) {

		Input input = new Input();
		Result result = new Result();
		Users users = input.saveUsers();
		Number ladderCount = input.saveLadderCount();
		List<Line> lines = new ArrayList<>();

		for (int number = INIT_NUMBER ; number < ladderCount.getNumber() ; ++number) {
			lines.add(new Line(users.count()));
		}

		result.viewUsers(users);
		result.viewLadder(lines);
	}
}

