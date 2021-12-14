package ladder.view;

import java.util.List;

import static ladder.view.InputViewUtil.asList;
import static ladder.view.InputViewUtil.userInput;

public class InputView {
    public static final String REGEX = ",";
    public static final int MIN_WIDTH = 2;
    public static final int MIN_HEIGHT = 1;

    private List<String> userList;
    private List<String> resultList;
    private int ladderHeight;

    public void setUserList() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        this.userList = asList(userInput().split(REGEX));

        validateUserList();
    }

    private void validateUserList() {
        if (userList.size() < MIN_WIDTH) {
            throw new IllegalStateException("user 는 2명 이상이어야 합니다.");
        }

        boolean isValidUserName = userList.stream()
                .allMatch(name -> name.length() <= 5);

        if (!isValidUserName) {
            throw new IllegalStateException("user 의 이름은 5글자 이하이여야 합니다.");
        }
    }

    public void setResultList() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        this.resultList = asList(userInput().split(REGEX));

        validateResultList();
    }

    private void validateResultList() {
        if (userList.size() != resultList.size()) {
            throw new IllegalStateException("user 의 수와 결과의 개수는 같아야합니다.");
        }
    }

    public void setLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.ladderHeight = Integer.parseInt(userInput());

        validateLadderHeight();
    }

    private void validateLadderHeight() {
        if (ladderHeight < MIN_HEIGHT) {
            throw new IllegalStateException("사다리의 최소 길이는 1 이상입니다.");
        }
    }

    public int getLadderWidth() {
        return this.userList.size();
    }

    public int getLadderHeight() {
        return this.ladderHeight;
    }

    public List<String> getUserList() {
        return this.userList;
    }

    public List<String> getResultList() {
        return this.resultList;
    }
}
