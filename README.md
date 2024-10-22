# 사다리 게임
## 진행 방법
* 사다리 게임 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/nextstep-step/nextstep-docs/tree/master/codereview)

## 기능 구현
- 익명 클래스 람다로 전환
- 람다를 활용해 중복 제거
- 스트림(Stream) map, filter, reduce 구현
- Optional 
  - 조건에 따른 반환
  - 값을 반환 
  - exception 처리
---

# 사다리 기능 구현

## 기능 명세서 

## Persons 클래스 - 이름들 구분
1. [✅] 참여할 사람 이름 구분자로 나누는 로직

## Person 클래스 - 이름
1. [✅] 참여할 사람 5글자 validate 체크 로직

## Line 클래스 
1. [✅] 수평선 추가 로직
2. [✅] 수평선 추가 시, validate 판단 로직
3. [✅] 수평선 리스트 반환

## Ladder 클래스
1. [✅] 사다리 개수 validate 체크 로직 
2. [✅] 처음 부터 라인 판단 리스트 List 로직 
3. [✅] 라인정보 반환 로직 

## LadderNumber 클래스 
1. [✅] 숫자 validate 검증 로직
2. [✅] 숫자 반환 로직

## InputView 클래스
1. [✅] 참가자 이름 입력 
2. [✅] 최대 사다리 높이 입력 

## ResultView 클래스
1. [✅] 사람이름 결과 반환
2. [✅] 사다리 이름 결과 반환

