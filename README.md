# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

# Step1

## 요구사항

### stream method 실습
#### 실습 1
- [x] List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다. 지금까지 학습한 map, reduce, filter를 활용해 구현해야 한다.
- [x] nextstep.fp.StreamStudyTest 클래스의 sumOverThreeAndDouble() 테스트를 pass해야 한다.

#### 실습 2
- [x] printLongestWordTop100() 메서드를 구현한다.
- [x] 단어의 길이가 12자를 초과하는 단어를 추출한다.
- [x] 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출한다.
- [x] 단어 중복을 허용하지 않는다.
- [x] 추출한 100개의 단어를 모두 소문자로 출력한다.

### Optional 실습
- [x] Optional을 활용해 ageIsInRange2() 메소드에 구현한다
- [x] nextstep.optional.Users의 getUser() 메소드를 자바 8의 stream과 Optional을 활용해 구현
- [x] nextstep.optional.ExpressionTest의 테스트가 통과하도록 Expression의 of 메소드를 구현한다.

# Step2

## 요구사항
- [x] 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다.
- [ ] 사다리를 출력할 때 사람 이름도 같이 출력한다. 
- [x] 사람 이름은 쉼표(,)를 기준으로 구분한다. 
- [ ] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다. 
- [ ] 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
- [ ] 자바 8의 스트림과 람다를 적용해 프로그래밍한다.