package step04.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderUsers {
    private static final String INVALID_RESULT_USER = "참여자에 포함되어 있지 않은 유저입니다.";
    private static final String USER_ALIGN_FORMAT = "%5s ";

    private final List<LadderUser> users;

    public LadderUsers(List<LadderUser> users) {
        this.users = Collections.unmodifiableList(users);
    }

    public int getUserNumber() {
        return users.size();
    }

    public String printableUserStatus() {
        return users.stream()
                .map(LadderUser::getName)
                .map(name -> String.format(USER_ALIGN_FORMAT, name))
                .collect(Collectors.joining());
    }

    public void validateResultUser(String resultUserName) {
        if (!users.contains(new LadderUser(resultUserName))) {
            throw new IllegalArgumentException(INVALID_RESULT_USER);
        }
    }

    public LadderUsers withRewards(RouteInfo<Integer> routeInfo, Rewards rewards) {
        Map<Integer, Integer> routeMap = routeInfo.getRouteMap();
        routeMap.keySet()
                .forEach(key -> users.get(key).withReward(rewards.getRewardByIndex(routeMap.get(key))));

        return this;
    }

    public Map<String, String> toMap(String resultUserName, boolean isAll) {
        Map<String, String> stringMap = getStringMap();

        if (isAll) {
            return stringMap;
        }

        return stringMap.keySet()
                .stream()
                .filter(key -> key.equals(resultUserName))
                .collect(Collectors.toMap(key -> key,
                        stringMap::get));
    }

    private Map<String, String> getStringMap() {
        return users.stream()
                .collect(LinkedHashMap::new,
                        (map, key) -> map.put(key.getName(), key.getRewardName()),
                        Map::putAll);
    }

    public boolean isEqualSize(int size) {
        return users.size() == size;
    }

    public LadderUser getUserByIndex(Integer key) {
        return users.get(key);
    }
}
