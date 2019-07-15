package ladder.domain;

import ladder.model.LadderNode;
import ladder.model.NameGoalPair;

import java.util.List;

public class Ladder {

	private LadderHeader header;

	private Ladder(Builder builder){
		/**
		 * Builder 정보를 통해 생성한 사다리의 주요 구성요소를
		 * 필요순서에 따라 체이닝
		 */

		// goal in footer
		LadderFooter footer = new LadderFooter(builder.goals);

		// footer to body
		LadderBody body = new LadderBody(builder.playerNames.size(),
				builder.height,
				builder.provider,
				footer);

		// body to header (player in header)
		this.header = new LadderHeader(builder.playerNames, body);
	}

	public List<LadderNode> getNodes() {
		return this.header.getNodes();
	}

	public String getGoal(String playName) {
		return this.header.getGoal(playName);
	}

	public List<NameGoalPair> getResult() {
		return this.header.getResult();
	}

	public static Builder builder(){
		return new Builder();
	}

	public static class Builder{

		private List<String> playerNames;

		private List<String> goals;

		private int height;

		private StepProvider provider;

		private Builder() {}

		public Builder setPlayerNames(List<String> playerNames){
			this.playerNames = playerNames;
			return this;
		}

		public Builder setGoals(List<String>  goals){
			this.goals = goals;
			return this;
		}

		public Builder setHeight(int height){
			this.height = height;
			return this;
		}

		public Builder setStepProvider(StepProvider provider){
			this.provider = provider;
			return this;
		}

		public Ladder build(){
			return new Ladder(this);
		}
	}
}
