package laddergame.domain.service;

import laddergame.domain.*;
import laddergame.dto.LadderRecord;
import laddergame.dto.RewardRecord;
import laddergame.dto.RewordRecords;

import java.util.*;

public class LadderGame {

    private final People people;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(People people, Rewards rewards, Ladder ladder) {
        this.people = people;
        this.rewards = rewards;
        this.ladder = ladder;
    }

    public static LadderGame of(People people, Rewards rewards, int countOfLadder) {
        return new LadderGame(people, rewards, Ladder.of(countOfLadder, people.numberOfPeople()) );
    }

    public List<PersonName> getPersonNames() {
        return people.getNames();
    }

    public RewordRecords makeResult(PersonName personName) {

        if (personName.isAll()) {
            return makeResultAll();
        }
        if (people.contains(personName)) {
            return makeResultOne(personName);
        }
        throw new IllegalArgumentException("all 또는 사다리 게임 참여자의 이름을 입력해주세요.");
    }

    private RewordRecords makeResultOne(PersonName personName) {

        List<RewardRecord> result = new ArrayList<>();

        int rewardIndex = ladder.findRewardIndex(people.getIndex(personName));
        result.add( RewardRecord.of(personName, rewards.getReward(rewardIndex)));

        return new RewordRecords(result);
    }

    private RewordRecords makeResultAll() {

        List<RewardRecord> result = new ArrayList<>();

        List<PersonName> names = people.getNames();
        for (PersonName name : names) {
            int rewardIndex = ladder.findRewardIndex(people.getIndex(name));
            result.add( RewardRecord.of(name, rewards.getReward(rewardIndex)));
        }

        return new RewordRecords(result);
    }

    public LadderRecord getLadderRecord() {
        return LadderRecord.of(ladder);
    }

    public Rewards getRewards() {
        return rewards;
    }
}
