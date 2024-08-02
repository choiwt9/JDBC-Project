/*
--JDBC�� ���� : C##JDBC / JDBC
CREATE USER C##JDBC IDENTIFIED BY JDBC;

GRANT CONNECT, RESOURCE TO C##JDBC;
--������ �������� ���� ���� ����
*/
--------------------------------------------------------------------------------
--ȸ�������� ������ ���̺�(MEMBER)

CREATE TABLE MEMBER(
USERNO NUMBER PRIMARY KEY,                               --ȸ����ȣ
USERID VARCHAR2(20) NOT NULL,                            --ȸ�����̵�
USERPW  VARCHAR2(20),                                    --ȸ�� ��й�ȣ
USERNAME VARCHAR2(20) NOT NULL,                          --�̸�
GENDER CHAR(1) CHECK(GENDER IN ('M', 'F')),              --����
AGE NUMBER,                                              --����
EMAIL VARCHAR2(30),                                      --�̸���
ADDRESS VARCHAR2(100),                                   --�ּ�
PHONE VARCHAR2(13),                                      --����ó
HOBBY VARCHAR2(50),                                      --���
ENROLLDATE DATE DEFAULT SYSDATE NOT NULL                 --������
);
--ȸ����ȣ�� ����� ������ ����
DROP SEQUENCE SEQ_USERNO;  --�ӽ�

CREATE SEQUENCE SEQ_USERNO
NOCACHE;

--���õ����� 2�� �߰�

INSERT INTO MEMBER
VALUES (SEQ_USERNO.NEXTVAL, 'admin', '1234', '������', 'M', 20, 'admin@kh.or.kr', '����', '010-1010-0101', null, '2020-07-30');
INSERT INTO MEMBER
VALUES (SEQ_USERNO.NEXTVAL, 'wontak', '1234', '�ֿ�Ź', 'F', 20, 'wontak@kh.or.kr', NULL, '010-9090-0101', null, DEFAULT);

COMMIT;
--------------------------------------------------------------------------------
--�׽�Ʈ�� ���̺� (TEST)
CREATE TABLE TEST(
TNO NUMBER,
TNAME VARCHAR2(20),
TDATE DATE
);

SELECT * FROM TEST;

INSERT INTO TEST VALUES(1, '��ٿ�', SYSDATE);

select*from Member;
commit;







