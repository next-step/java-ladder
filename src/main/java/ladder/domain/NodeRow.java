package ladder.domain;

import ladder.exception.OutOfRailNumberException;
import ladder.model.LadderNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class NodeRow {

	private List<LadderNode> nodes;

	public NodeRow(int railCount, StepProvider provider){
		LadderNode node = LadderNode.create();
		this.nodes = new ArrayList<>();
		this.nodes.add(node); // 좌측 첫번째 레일(엣지)에는 스텝 설치 불가

		while (nodes.size() < railCount){
			// 직전에 추가된 Step 이 false 일 때 true 값이 추가 될 수 있다.
			node = node.createNextNode(provider.generate());
			nodes.add(node);
		}
	}

	/**
	 * 레일 번호를 입력하면 가로계단 연결 상태를 확인하고 다음 열 번호를 반환하는 메서드
	 * @param railNumber 출발 레일번호
	 * @return	도착 레일번호
	 */
	public int getNextRailFrom(int railNumber) {
		if(railNumber < 0){
			throw new OutOfRailNumberException();
		}

		if(railNumber >= nodes.size()){
			throw new OutOfRailNumberException();
		}

		return nodes.get(railNumber).nextRailNumber();
	}

	public Stream<LadderNode> getSteps(){
		return nodes.stream();
	}
}
