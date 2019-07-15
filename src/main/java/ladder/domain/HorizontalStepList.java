package ladder.domain;

import ladder.exception.OutOfRailNumberException;
import ladder.model.LadderNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class HorizontalStepList {

	private List<LadderNode> nodes;

	public HorizontalStepList(int railCount, StepProvider provider){
		this.nodes = new ArrayList<>();
		this.nodes.add(new LadderNode(0, false)); // 좌측 첫번째 레일(엣지)에는 스텝 설치 불가

		while (steps.size() < railCount){
			// 직전에 추가된 Step 이 false 일 때 true 값이 추가 될 수 있다.
			steps.add(provider.generate() && !steps.get(steps.size() - 1));
		}
	}

	private boolean hasLeftStepAt(int railNumber){
		return steps.get(railNumber);
	}

	private boolean hasRightStepAt(int railNumber){
		return (railNumber == steps.size() - 1) ? false : steps.get(railNumber + 1);
	}

	/**
	 * 주어진 열을 추가 할 수 있는지 여부를 반환하는 메서드, 개수가 같아야 추가가능하다.
	 * @param row 추가하려는 열
	 * @return 추가 가능여부
	 */
	public boolean isAppendable(HorizontalStepList row) {
		return this.steps.size() == row.steps.size();
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

		if(railNumber >= steps.size()){
			throw new OutOfRailNumberException();
		}

		if(this.hasRightStepAt(railNumber)){
			return railNumber + 1;
		}

		if(this.hasLeftStepAt(railNumber)){
			return railNumber - 1;
		}

		return railNumber;
	}

	public Stream<LadderNode> getSteps(){
		return Collections.unmodifiableCollection(steps).stream();
	}
}
