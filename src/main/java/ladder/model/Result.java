package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private Users users;
    private List<String> resultItems;

    public Result(Users users, String reustItem) {
        this.users = users;
        resultItems = validation(users.userCount(), reustItem);
    }

    public List<String> getResultItem(){
        return Collections.unmodifiableList(resultItems);
    }

    public int maxLadderTextCount(){
        if(users.getMaxUserNameLength() - maxItemLength() > 0){
            return users.getMaxUserNameLength();
        }

        return maxItemLength();
    }

    public String getUserResult(User targetUser, Ladder ladder) {
        if(!users.getUsers().contains(targetUser)){
            throw new IllegalStateException("사다리 게임에 참여한 사용자 이름이 아닙니다.");
        }
        return userRiding(targetUser, ladder);
    }

    public List<String> getAllUserResult(Users users, Ladder ladder) {
        return users.getUsers().stream()
                .map(user -> userRiding(user, ladder))
                .collect(Collectors.toList());
    }

    private int maxItemLength(){
        return resultItems.stream()
                          .map(String::length)
                          .max(Integer::compare)
                          .get();
    }

    private List<String> validation(int userCount, String reustItem){
        String[] items = reustItem.split(",");
        if(userCount != items.length){
            throw new IllegalStateException("사다리 게임 결과 값은 게임 참여자 수와 같아야 합니다.");
        }
        return Arrays.asList(items);
    }

    private String userRiding(User targetUser, Ladder ladder){
        int userIdx = users.userIndex(targetUser);
        int resultItemIndex = ladder.ladderRiding(userIdx);
        return resultItems.get(resultItemIndex);
    }
}
