package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
	private final Players players;
	private final Ladder ladder;

	public LadderGame(Players players, int heightOfLadder) {
		this.players = players;
		this.ladder = LadderGenerator.generateLadder(heightOfLadder, this.players);
	}

	public LadderResult play(Rewards rewards) {
		if (!(players.size() == rewards.size())) {
			throw new IllegalArgumentException();
		}

		Map<Player, Reward> ladderResult = new HashMap<>();
		for (Player player : players.getPlayers()) {
			Point result = resultOfPlayer(players.pointOfPlayer(player), ladder);
			ladderResult.put(player, rewards.rewardByResult(result));
		}
		return new LadderResult(ladderResult);
	}

	public static Point resultOfPlayer(Point playerPoint, Ladder ladder) {
		Point point = playerPoint;
		for (Line line : ladder.getLadder()) {
			if (point.isFirst()) {
				point = point.isMove(Direction.first(line.isLine(point.getIndex())));
				continue;
			}
			if (!point.isFirst() && !point.isLast(line.size())) {
				point = point.isMove(Direction.of(line.isLine(point.getIndex() - 1), line.isLine(point.getIndex())));
				continue;
			}
			if (point.isLast(line.size())) {
				point = point.isMove(Direction.last(line.isLine(point.getIndex() - 1)));
				continue;
			}
		}
		return point;
	}

	public Players getPlayers() {
		return players;
	}

	public Ladder getLadder() {
		return ladder;
	}

}
