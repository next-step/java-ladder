package controller;

import domain.Number;
import domain.Users;
import utils.Input;
import utils.Result;

public class LadderGame {
	public static void main(String[] args) {

		Input input = new Input();
		Result result = new Result();
		Users users = input.saveUsers();
		Number ladderCount = input.saveLadderCount();

		result.viewUsers(users);
	}
}

