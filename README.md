# 사다리 게임

## PR 링크 정리
- step1 : https://github.com/next-step/java-ladder/pull/1680
- step2 : https://github.com/next-step/java-ladder/pull/1790

## 진행 방법

* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정

* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## STEP 1 학습테스트 & 요구사항 체크리스트

- [x] lambda 실습 1 : MoveStrategy에 대한 익명 클래스로 구현하고 있는데 람다를 적용
- [x] lambda 실습 2 : 3보다 큰 수만을 더하는 로직구현, 중복코드 제거
- [x] map, reduce, filter 실습 1 : List에 담긴 모든 숫자 중 3보다 큰 숫자를 2배 한 후 모든 값의 합을 구한다
- [x] map, reduce, filter 실습 2 : printLongestWordTop100() 메서드를 구현
- [x] Optional 실습1 : 조건에 따른 반환
- [x] Optional 실습2 : 값을 반환
- [x] Optional 실습3 : exception 처리

## STEP2

### TDD 진행에 관하여

- 한방에 모든 테스트를 작성하고 개발할수가 없다. 전체 요구사항을 잘게 쪼개서
- 설계 >> RED Test >> 구현 >> Green Test >> 리팩토링 :: 해당 과정들을 짧은 주기로 여러번 반복해서 진행하였습니다


## 구현관련 
- 목적이 있는 테스트코드
  - 주제 : 모든 테스트코드에는 "테스트 대상" 과 "테스트코드의 의도 & 목적" 을 잘 드러내기 위해 노력했습니다
  - 왜냐하면 : 테스트코드에는 "무엇을 테스트하고자 하는지" 에 대한 정보가 들어있어야 한다고 생각하기 때문입니다
  - 노력한 부분은 : 필수요소가 아닌 juit::as() 메서드를 활용하고, @DisplayName 등의 메서드를 활용하였습니다.

- CrossIntersection 방지 로직 적용
  - 주제 : 미션의 요구사항으로는 존재하는 `사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다` 기능
  - `|-----|-----|` 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없기때문에 해당 케이스는 발생하지 않도록 구현

- Preferences 개념 도입
  - 주제 : 사다리 최대 높이(Max Column) 사다리 최대 너비(Max Row) 등에 대한 설정을 Preferences 클래스에서 통합하여 관리하게 만들었습니다.


## 이외
- 지난번 Step1 리뷰에서 추가 코멘트 주신 부분이 두가지 있었는데요
```text
Lambda 학습테스트에서의 의도를 잘못 파악한 부분
StreamStudy 클래스에서의 중복 제거 (File 에 저장되어있는 Dataset Loading 부분)
```
- 위 2가지 사항에 대해서 수정반영 했습니다

