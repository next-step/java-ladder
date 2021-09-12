package controller;

import domain.Number;
import domain.Users;
import utils.Input;

public class LadderGame {
	public static void main(String[] args) {

		Input input = new Input();
		Users users = input.saveUsers();
		Number ladderCount = input.saveLadderCount();
	}
}

