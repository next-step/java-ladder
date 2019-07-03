package ladder.domain;

import ladder.exception.OutOfRailNumberException;

import java.util.ArrayList;
import java.util.List;

public class HorizontalStepList {

	private List<Boolean> steps;


	public HorizontalStepList(int railCount, StepProvider stepProvider){
		this.steps = new ArrayList<>();
		this.steps.add(false); // 좌측 첫번째 레일(엣지)에는 스텝 설치 불가

		do{
			steps.add(stepProvider.isInstallStep() && !steps.get(steps.size() - 1));
		}while (steps.size() < railCount);
	}

	public boolean hasLeftStepAt(int railNumber){
		if(railNumber < 0){
			throw new OutOfRailNumberException();
		}

		return (railNumber == 0) ? false : steps.get(railNumber);
	}

	public boolean hasRightStepAt(int railNumber){
		if(railNumber >= steps.size()){
			throw new OutOfRailNumberException();
		}

		return (railNumber == steps.size() - 1) ? false : steps.get(railNumber + 1);
	}
}
