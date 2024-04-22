# KiWi (여행 소개 커뮤니티) 

## 시연영상
https://youtu.be/cNw_A4f9OMk

## 기술 스택
<img width="976" alt="image" src="https://github.com/squareyun/kiwi/assets/33932392/6178db9a-6d6d-40b2-ab32-e3150a3e3039">

## ERD
<img src="https://github.com/squareyun/kiwi/assets/33932392/95a3c377-4124-41d5-8178-a1c2e6fcd295">

## 기능
### 메인화면
![메인화면](https://github.com/wlgns1718/kiwitravel/assets/113763592/018ba9d3-b46d-4836-9e87-b013cbba0641)


### 로그인화면
![로그인화면](https://github.com/wlgns1718/kiwitravel/assets/113763592/5f51f9f2-6eb8-48fb-861d-eed72408ee52)


### 회원가입화면
![회원가입](https://github.com/wlgns1718/kiwitravel/assets/113763592/3688d5b8-2868-4791-8986-f59e36fb6836)


### 글작성 화면
![글 작성 예시](https://github.com/wlgns1718/kiwitravel/assets/113763592/c243721d-468a-4fd2-b136-459638f7edb0)


### 글 작성시 필터 기능
![필터 설정 가능](https://github.com/wlgns1718/kiwitravel/assets/113763592/06e6edee-899d-4c4f-93b7-3d19c4794df7)


### 글목록 화면
![글 목록](https://github.com/wlgns1718/kiwitravel/assets/113763592/cd4fc47d-a932-4d84-b07a-7d4b026ade11)


### 댓글 기능
![댓글 테스트](https://github.com/wlgns1718/kiwitravel/assets/113763592/2e105c26-d39c-49cb-878b-b7764293078a)

### 미이페이지
![마이 페이지](https://github.com/wlgns1718/kiwitravel/assets/113763592/ef8f7db9-bdd6-4ca3-b54b-bcc61156128e)


### 관광지명소 검색
![관광지 명소](https://github.com/wlgns1718/kiwitravel/assets/113763592/78cb6438-69d8-494c-b745-56bf30a874b8)

## 후기
>처음 경험한 웹 개발 프로젝트입니다. 기능 구현을 가장 첫 번째 목표로 생각했고, 기능의 개선, 발생할 수 있는 오류에 대한 대처는 이후에 생각하기로 했습니다. Vue.js를 사용하여 SPA 개발 방법에 대해 알게 되었고, MVVM 패턴을 이해할 수 있었습니다. 또한 MyBatis를 이용한 RESTful API를 개발하여 원하는 결과를 조회하기 위한 SQL 역량을 높일 수 있었습니다. 또한 기초적인 실수를 경험하고 해결하며 문제해결을 위한 과정과 방법을 알게 되었습니다.

**트러블 슈팅**
>**Failed to configure a DataSource** : 
Database에 연결할 때 필요한 정보가 없기 때문 => DB관련 정보 추가하며 해결
>
**java.lang.ClassNotFoundException: javax.xml.bind.DatatypeConverter(JWT 관련 오류)** : 
JDK 11 이 되면서 Java EE와 CORBA Module이 제거 => JAXB API의 Maven을 추가하여 해결

**nested exception is org.apache.ibatis.exceptions.PersistenceException** : 
Entity에 생성자를 만들어 발생 => 생성자를 제거하며 해결

**input file을 form data로 받고 서버로 넘겨주면서 NULL이 뜨는 오류** : 
Form data에서 append를 하게 되면 String이 아닌 모든 객체들은 String으로 자동으로 변환되어 append가 된다. 이때 해당 이미지 파일 리스트에서 인덱스로 접근로 접근 후 바로 append를 하게 되면 “Object”의 String형태로 들어가기 때문에 Null값이 발생 => file을 담은 배열에서 인덱스로 접근 후 .file로 파일 정보를 불러 append를 해주면 정상적으로 서버에 전송이 된다

<img width="700" alt="image" src="https://github.com/squareyun/kiwi/assets/33932392/cc426f6d-c2fd-4465-bf7a-ed0bb37b871c">
