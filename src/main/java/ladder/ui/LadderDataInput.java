package ladder.ui;

import java.util.List;

import ladder.domain.Participants;
import ladder.domain.Reward;

public class LadderDataInput {

    private static final String MSG_INPUT_PLAYER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MSG_INPUT_REWARD = "실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MSG_INPUT_LADDER_SIZE = "최대 사다리 높이는 몇 개인가요?";

    private Participants participants;
    private int height;
    private Reward reward;

    public LadderDataInput(Input input, Output output) {
        inputNames(input, output);
        inputReword(input, output);
        inputHeight(input, output);
    }

    private void inputNames(Input input, Output output) {
        output.print(MSG_INPUT_PLAYER_NAME);
        participants = new Participants(input.nextLine());
    }

    private void inputReword(Input input, Output output) {
        output.print(MSG_INPUT_REWARD);
        reward = new Reward(input.nextLine());
    }

    private void inputHeight(Input input, Output output) {
        output.print(MSG_INPUT_LADDER_SIZE);
        height = input.nextInt();
    }

    public List<String> getPlayerNames() {
        return participants.getNames();
    }

    public int getPlayerCount() {
        return participants.getNames().size();
    }

    public int getHeight() {
        return height;
    }

    public int getPlayerIndex(String playerName) {
        return participants.getPlayerIndex(playerName);
    }

    public Reward getReward() {
        return reward;
    }

    public Participants getParticipant() {
        return participants;
    }
}
