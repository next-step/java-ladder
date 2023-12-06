package nextstep.ladder.controller;

import java.util.List;

import nextstep.ladder.domain.User;
import nextstep.ladder.view.InputView;

public class LottoController {
	public static void main(String[] args) {
		List<User> users = InputView.inputUsers();
	}
}
