package step1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {

    private final List<UserName> userNames = new ArrayList<>();

    public UserNames(List<UserName> userNames) {
        validateUserNames(userNames);
        this.userNames.addAll(userNames);
    }

    public static UserNames from(List<String> userNames) {
        return new UserNames(userNames.stream()
            .map(UserName::new)
            .collect(Collectors.toList()));
    }

    public UserName getByIdx(int idx) {
        return userNames.get(idx);
    }

    public List<String> getPrimitiveUserNames() {
        return userNames.stream()
            .map(UserName::getUserName)
            .collect(Collectors.toList());
    }

    public int size() {
        return userNames.size();
    }

    private void validateUserNames(List<UserName> userNames) {
        validateIsEmpty(userNames);
        validateDuplicated(userNames);
    }

    private static void validateIsEmpty(List<UserName> userNames) {
        if (userNames == null || userNames.isEmpty()) {
            throw new IllegalArgumentException("userNames은 비어있을 수 없습니다.");
        }
    }

    private static void validateDuplicated(List<UserName> userNames) {
        if (userNames.stream().distinct().count() != userNames.size()) {
            throw new IllegalArgumentException("userNames은 중복될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserNames)) {
            return false;
        }

        UserNames userNames1 = (UserNames) o;

        return userNames != null ? userNames.equals(userNames1.userNames) : userNames1.userNames == null;
    }

    @Override
    public int hashCode() {
        return userNames != null ? userNames.hashCode() : 0;
    }
}
