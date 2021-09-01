package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Members {

	private List<Member> members;

	private Members(List<Member> members) {
		this.members = members;
	}

	public static Members of(List<String> members) {
		return members.stream()
					.map(Member::new)
					.collect(collectingAndThen(toList(), Members::new));
	}

	public static Members of(String members) {
		return of(Arrays.stream(members.split(","))
					.map(String::trim)
					.collect(toList()));
	}

	public int size() {
		return members.size();
	}

	public Member member(int index) {
		return members.get(index);
	}
}
