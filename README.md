# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 🚀 1단계 - 자바8 스트림, 람다, Optional

### 요구사항

#### Lambda
- [x] 익명 클래스를 람다로 전환 nextstep.fp.CarTest
- [x] 람다를 활용해 중복 제거 // nextstep.fp.Lambda의 sumAll, sumAllEven, sumAllOverThree method 소스 코드를 확인하고 중복 제거한다.
#### Stream 
- [x] map, reduce, filter 실습 1 // List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다.
- [x] map, reduce, filter 실습 2 // nextstep.fp.StreamStudy 클래스의 printLongestWordTop100() 메서드를 구현
#### Optional
- [x] 요구사항 1 - Optional을 활용해 조건에 따른 반환
- [x] 요구사항 2 - Optional에서 값을 반환
- [x] 요구사항 3 - Optional에서 exception 처리

## 🚀 2 ~ 4단계 - 사다리게임

### 기능 요구사항
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다
- 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.

### 프로그래밍 요구사항
- 자바 8의 스트림과 람다를 적용해 프로그래밍한다.
- 규칙 6: 모든 엔티티를 작게 유지한다.

### TODO
- [x] Apply Step1 Feedbacks

InputView :
- [x] 사다리 게임에 참여하는 사람 이름 목록을 입력 받을 수 있다.
	- 제약 조건 :
		- Person Name
			- 1 <= lengh of each person name <= 5
			- person name should be numeric
		- Person Name List
			- 2 <= number of persons <= Integer.MAX
			- 쉼표를 기준으로 사람 이름 목록으로 부터, 사람 이름을 구분해야 한다.
	- 제약 조건을 만족하지 못할경우, 에러를 출력하고 프로그램을 종료한다.
		- 예) 
			- 사람 이름이 Null일 경우
			- 사람 이름이 Empty일 경우
			- 사람 이름이 Non-numeric할 경우
			- 사람수가 2명이하인경우
			- 쉼표 기준으로 사람 이름을 구분하지 못할 경우
- [x] 최대 사다리 높이를 입력 받을 수 있다.
	- 제약 조건 :
		- Ladder Height
			- 1 <= ladder height <= Integer.MAX
			- ladder height should be numeric
	- 제약 조건을 만족하지 못할경우, 에러를 출력하고 프로그램을 종료한다.
		- 예)
			- 사다리 높이가 1 이하 일 경우
			- 사다리 높이가 Null일 경우
			- 사다리 높이가 Empty일 경우
			- 사라디 높이가 Non-Numeric할 경우

- [x] OutputView:
	- 입력 받은 사람 이름을 출력 할 수 있다.
	- 입력 받은 사람 이름 목록과, 사다리 높이를 기준으로 생성한 사다리를 출력 할 수 있다.

- [x] Domain :
	- 입력 받은 사람 이름 목록과, 사다리 높이를 기준으로 사다리를 생성할 수 있다.


## Note
##### Better optional practice
```java
// ASIS
    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
            .filter(optUser ->
                Objects.nonNull(optUser.getAge())
                && optUser.getAge() >= 30
                && optUser.getAge() <= 45)
            .isPresent();
    }
// TOBE
    public static boolean ageIsInRange2(User user) {
        return Optional.ofNullable(user)
            .map(optUser -> optUser.getAge())
            .filter(age -> 30 <= age && age <= 45)
            .isPresent();
    }
```

##### Optional Exception
```java
// Need to wrap with {}
    static Expression of(String expression) {
        return Arrays.stream(values())
            .filter(value -> matchExpression(value, expression))
            .findFirst()
            .orElseThrow(() -> {
                throw new IllegalArgumentException(
                    String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", expression));
            });
    }

```

##### Lamda and Exception
- 미리 정의된 @FunctionInterface does not throw Checked Exception(e.g, IOException)
- 따라서, 람다에서 CheckedException을 던지고 싶을땐,
1) Create custom @FunctionInterface
```java
@FunctionalInterface
interface Processor {
	String process(BufferedReader b) throws IOException;
}

```
2) 람다 안에서 CheckedException잡아서, Unchecked로 전환하기
```java
Function<BufferedReader, String> f = (BufferedReader b) -> {
	try {
		return b.readLine();
	} catch (IOException e) {
		throw new RuntimeException(e);
	}
}
```


