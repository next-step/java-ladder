package ladder.domain;

import ladder.exception.OutOfRailNumberException;
import ladder.model.LadderNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class NodeRow {

	private List<LadderNode> nodes;

	public NodeRow(int railCount, StepProvider provider) {
		this.nodes = new ArrayList<>();
		this.nodes.add(LadderNode.create());

		while (nodes.size() < railCount) {
			LadderNode lastNode = nodes.get(nodes.size() - 1);
			nodes.add(lastNode.createNextNode(provider.generate()));
		}
	}

	/**
	 * 레일 번호를 입력하면 가로계단 연결 상태를 확인하고 다음 열 번호를 반환하는 메서드
	 *
	 * @param railNumber 출발 레일번호
	 * @return 도착 레일번호
	 */
	public int getNextRailFrom(int railNumber) {
		if (railNumber < 0) {
			throw new OutOfRailNumberException();
		}

		if (railNumber >= nodes.size()) {
			throw new OutOfRailNumberException();
		}

		return nodes.get(railNumber).nextRailNumber();
	}

	public Stream<LadderNode> getSteps() {
		return nodes.stream();
	}
}
