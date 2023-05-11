# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)


## step1(1단계) - 스트림, 람다, Optional

---

### 람다 실습
- [x] 익명 클래스를 람다로 전환
  > `CarTest`
- [x] 람다를 활용해 중복 제거
  > `Lambda` 클래스의 `sumAll`, `sumAllEven`, `sumAllOverThree` 메서드

### 스트림 실습
- [x] `StreamStudyTest` 클래스의 `sumOverThreeAndDouble()` 테스트 구현
  > `map`, `reduce`, `filter` 활용
- [x] `StreamStudy` 클래스의 `printLongestWordTop100()` 메서드 구현
  > 단어의 길이가 12자를 초과하는 단어 추출  
  > 12자가 넘는 단어 중 길이가 긴 순서로 100개의 단어를 추출  
  > 단어 중복을 허용하지 않는다. 즉, 서로 다른 단어 100개를 추출    
  > 추출한 100개의 단어를 소문자로 출력
  
### Optional 실습
- [x] `User` 클래스의 `ageIsInRange2()` 메서드 구현
  > `ageIsInRange1()` 메서드와 동일한 기능  
  > 메소드 인자로 받은 `User`를 `Optional`로 생성하여 메서드 구현
- [x] `Users` 클래스의 `getUser()` 메서드를 `stream`과 `Optional`을 활용해 리팩토링
- [x] `Expression`의 `of` 메서드를 `stream` 기반으로 리팩토링