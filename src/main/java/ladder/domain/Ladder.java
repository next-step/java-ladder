package ladder.domain;

import ladder.model.LadderNode;
import ladder.model.NameGoalPair;

import java.util.List;
import java.util.Random;

public class Ladder {

	private LadderHeader header;

	private Ladder(Builder builder) {
		/**
		 * Builder 정보를 통해 생성한 사다리의 주요 구성요소를
		 * 참조관계에 따라 체이닝
		 * header <- body <- footer
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

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private static final int LADDER_MIN_HEIGHT = 1;

		private List<String> playerNames;

		private List<String> goals;

		private int height;

		private StepProvider provider;

		private Builder() {
			Random random = new Random();
			provider = random::nextBoolean;
			height = LADDER_MIN_HEIGHT;
		}

		public Builder setPlayerNames(List<String> playerNames) {
			this.playerNames = playerNames;
			return this;
		}

		public Builder setGoals(List<String> goals) {
			this.goals = goals;
			return this;
		}

		/**
		 * 사다리 높이, 지정하지 않을 경우 기본값 1
		 *
		 * @param height
		 * @return
		 */
		public Builder setHeight(int height) {
			this.height = height;
			return this;
		}

		/**
		 * 계단 설치여부 공급자
		 * 지정하지 않을 경우 랜덤공급자가 기본 제공됨
		 *
		 * @param provider
		 * @return
		 */
		public Builder setStepProvider(StepProvider provider) {
			this.provider = provider;
			return this;
		}

		public Ladder build() {

			if (playerNames == null) {
				throw new IllegalStateException("참가자 목록은 반드시 지정되야 합니다.");
			}

			if (goals == null) {
				throw new IllegalStateException("사다리 목표지점 정보가 없습니다.");
			}

			if (playerNames.size() != goals.size()) {
				throw new IllegalStateException("참자가 수와 목표지점 정보 개수가 일치하지 않습니다.");
			}

			if (height < LADDER_MIN_HEIGHT) {
				throw new IllegalStateException(String.format("최소 사다리 높이는 %d입니다.", LADDER_MIN_HEIGHT));
			}

			return new Ladder(this);
		}
	}
}
