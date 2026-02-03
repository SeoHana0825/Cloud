### CH 4 클라우드_아키텍처 설계 & 배포

## 1. 프로젝트 소개
아무것도 없는 상태에서 팀원들의 정보를 저장하고
프로필 사진을 업로드하는 API를 만들어 AWS 상에서 안전하고 중단 없이 운영해야하는 스타트업 백엔드 개발자라고 생각하기

## 2. 프로젝트 목적
- 네트워크 구축
- DB와 파일 저장소의 분리
- 서버가 죽어도 데이터가 안전한 Stateless 아키텍쳐 를 완성해라.

---
## 3. 프로젝트 내용

#### ◆ Lv. 0 요금 폭탄 방지 AWS Budget 설정
실수로 인한 고가의 리소스를 켜두는 것을 방지할 수 있다.
- 설정 요구사항 :
    - AWS Budgets에서 월 예산 $100 으로 설정
    - 예산의 80% 도달 시 이메일 알림이 오도록 설정
  <img width="1896" height="860" alt="Lv0" src="https://github.com/user-attachments/assets/34bbeb5c-f166-469d-867a-079aca9e6750" />

#### ◆ LV 1 - 네트워크 구축 및 핵심 기능 배포
안전한 네트워크 환경을 만들어 운영 가능한 상태의 애플리케이션을 외부에 배포할 수 있다.
- 설정 요구사항 :
    - 인프라 구축 (VPC & EC2)
    - 애플리케이션 개발 - API
    - 애플리케이션 개발 - 운영설정
    - 애플리케이션 개발 - 상태 모니터링 Actuator
    - 배포 및 검증
  <img width="632" height="417" alt="Lv1" src="https://github.com/user-attachments/assets/bd37c066-238e-47d8-ad98-105fa3e0eba0" />

#### ◆ LV 2 - DB 분리 및 보안 연결하기
AWS 관리형 서비스를 이용해 DB를 분리, 안전하게 배포할 수 있다.
- 설정 요구사항 :
    - 인프라 요구사항 - RDS 구축
    - 인프라 요구사항 - 보안 그룹 체이닝
    - 인프라 요구사항 - Parameter Store.
    - 애플리케이션 요구사항
    - 검증

- RDS 보안 그룹 스크린샷
<img width="1790" height="529" alt="lv2 RDS 보안 그룹 스크린샷" src="https://github.com/user-attachments/assets/a82af3e4-43bc-4aa1-86bb-81638be7024a" />

- Actuator Info 엔드포인트 URL

#### ◆ LV 3 - 프로필 사진 기능 추가와 권한 관리
S3를 이용해 서버 디스크에 저장한 팀원 정보를 서버 다운 시에도 사용할 수 있게 할 수 있다.
- 설정 요구사항 :
    - 인프라 요구사항 - S3 버킷 생성
    - 인프라 요구사항 - IAM Role 생성
    - API 요구사항

- 발급받은 Presigned URL 1개와 해당 URL의 만료 시간

---
## 4. 메인 프로젝트 
    📁 build/
        └── 📁libs/                    # Bootjar    
    📁 src/  
        └── 📁main/  
          └── 📁java/
            └── 📁com.taskcloud/
                  └── 📁common/    # GlobalExceptionHandler
                  └── 📁controller/    #요청 전달
                  └── 📁dto/           #requeset, response 클래스 보관
                  └── 📁entity/        #DB 정보
                  └── 📁repository/    #레퍼지토리
                  └── 📁service/       #비즈니스 로직 관리

- API 명세서

|기능|메서드|URL|request|response||
|:--|:--|:--|:--|:--|:--|
|등록|POST|/api/members |{ <br>  &nbsp; "name": "김아무개", <br>  &nbsp; "email": "advsad@naver.com", <br>  &nbsp;  "birthday" : 02.08.06, <br>  &nbsp; 	"mbti":"ISTP" &nbsp;  <br>}|{ <br>  &nbsp; "id": 1, <br>  &nbsp; "name": "김아무개", <br>  &nbsp; "email": "advsad@naver.com", <br>  &nbsp;  "birthday" : 02.08.06, <br>  &nbsp; 	"mbti":"ISTP" &nbsp;  <br>}|201 created|
|전체 조회|GET|/api/members| |{ <br>  &nbsp; "id": 1, <br>  &nbsp; "name": "김아무개", <br>  &nbsp; "email": "advsad@naver.com", <br>  &nbsp;  "birthday" : 02.08.06, <br>  &nbsp; 	"mbti":"ISTP" &nbsp;  <br>}|200 OK|
|단건 조회|GET|/api/members/{id}||{ <br>  &nbsp; "id": 1, <br>  &nbsp; "name": "김아무개", <br>  &nbsp; "email": "advsad@naver.com", <br>  &nbsp;  "birthday" : 02.08.06, <br>  &nbsp; 	"mbti":"ISTP" &nbsp;  <br>}|200 OK|
|health|GET|/actuator/health||{<br>  &nbsp; "status": "UP" <br>  &nbsp;}|200 OK|

- 사용 언어 및 사용 프로그램
  - Java (IntelliJ)
  - Spring
  - MySQL
  - Lombok
  - AWS
  - Bootjar   
