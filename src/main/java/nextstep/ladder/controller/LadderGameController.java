package nextstep.ladder.controller;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Player;
import nextstep.ladder.model.Players;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LadderGameController {

	public static void main(String[] args) {
		String[] strings = Input.inputPlayers();
		Players players = Arrays.stream(strings)
			.map(Player::new)
			.collect(Collectors.collectingAndThen(Collectors.toList(), Players::new));

		Ladder ladder = new Ladder(Input.inputLadderHeights(), players.number());

		Output.outputResult(ladder, players);
	}
}
