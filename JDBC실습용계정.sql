/*
--JDBC용 계정 : C##JDBC / JDBC
CREATE USER C##JDBC IDENTIFIED BY JDBC;

GRANT CONNECT, RESOURCE TO C##JDBC;
--관리자 계정으로 위의 내용 진행
*/
--------------------------------------------------------------------------------
--회원정보를 저장할 테이블(MEMBER)

CREATE TABLE MEMBER(
USERNO NUMBER PRIMARY KEY,                               --회원번호
USERID VARCHAR2(20) NOT NULL,                            --회원아이디
USERPW  VARCHAR2(20),                                    --회원 비밀번호
USERNAME VARCHAR2(20) NOT NULL,                          --이름
GENDER CHAR(1) CHECK(GENDER IN ('M', 'F')),              --성별
AGE NUMBER,                                              --나이
EMAIL VARCHAR2(30),                                      --이메일
ADDRESS VARCHAR2(100),                                   --주소
PHONE VARCHAR2(13),                                      --연락처
HOBBY VARCHAR2(50),                                      --취미
ENROLLDATE DATE DEFAULT SYSDATE NOT NULL                 --가입일
);
--회원번호로 사용할 시퀀스 생성
DROP SEQUENCE SEQ_USERNO;  --임시

CREATE SEQUENCE SEQ_USERNO
NOCACHE;

--샘플데이터 2개 추가

INSERT INTO MEMBER
VALUES (SEQ_USERNO.NEXTVAL, 'admin', '1234', '관리자', 'M', 20, 'admin@kh.or.kr', '서울', '010-1010-0101', null, '2020-07-30');
INSERT INTO MEMBER
VALUES (SEQ_USERNO.NEXTVAL, 'wontak', '1234', '최원탁', 'F', 20, 'wontak@kh.or.kr', NULL, '010-9090-0101', null, DEFAULT);

COMMIT;
--------------------------------------------------------------------------------
--테스트용 테이블 (TEST)
CREATE TABLE TEST(
TNO NUMBER,
TNAME VARCHAR2(20),
TDATE DATE
);

SELECT * FROM TEST;

INSERT INTO TEST VALUES(1, '기다운', SYSDATE);

select*from Member;
commit;







