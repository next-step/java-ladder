package nextstep.ladder.domain;

public class Users {
    private String names;

    public Users(String names) {
        checkMultipleUsers(names);
        this.names = names;
    }

    private void checkMultipleUsers(String names) {
        if(!names.contains(",")) {
            throw new IllegalArgumentException("게임 참여자는 2명 이상이어야 합니다.");
        }
    }

}
