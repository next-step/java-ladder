package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RailSetupData {
	private List<NameGoalPair> railWithPlayerAndGoal;

	public RailSetupData(List<String> playerNames, List<String> goals){
		if(playerNames.size() != goals.size()){
			throw new IllegalArgumentException("참여자정보와 목표지점 정보 개수가 다릅니다.");
		}

		this.railWithPlayerAndGoal = new ArrayList<>();

		for(int i = 0; i < playerNames.size(); i++){
			this.railWithPlayerAndGoal.add(new NameGoalPair(playerNames.get(i), goals.get(i)));
		}
	}



}
