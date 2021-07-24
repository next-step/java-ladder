package nextstep.ladder.domain;

public class Winner {
    private Member member;
    private Prize prize;

    private Winner(Member member, Prize prize) {
        this.member = member;
        this.prize = prize;
    }

    public static Winner of(Member member, Prize prize) {
        return new Winner(member, prize);
    }

    public Member member() {
        return member;
    }

    public Prize prize() {
        return prize;
    }
}
