package domain;

public class LadderMember {
    private String memberArr[];
    private String result[];

    private LadderMember(String[] memberArr, String[] result) {
        this.memberArr = memberArr;
        this.result = result;
    }

    public static LadderMember from(String[] memberArr, String[] result) {
        return new LadderMember(memberArr, result);
    }

    public String[] getMemberArr() {
        return memberArr;
    }

    public String[] getResult() {
        return result;
    }

    public String memberNo(Integer i) {
        return memberArr[i];
    }

    public String resultNo(int index) {
        return result[index];
    }
}
