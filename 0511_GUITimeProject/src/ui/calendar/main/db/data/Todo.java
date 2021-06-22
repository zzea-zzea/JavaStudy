package ui.calendar.main.db.data;

import java.util.Date;

/* �޷� ���ڱ�� ������ ǥ���ϴ� ��Ű�� 
 * 
 * ���� 
 * todo ����
 * 
  Todo Ŭ����    <------>  MYTIME.todos ���̺�
 * 
 * id ������ȣ   int   <------>   number   <<PK>>
 * memo ����(����)  String   <------>  varchar2(145)
 * userName ������̸�  String  <------>   user_name  varchar2(24)
 * memoType ���� ����  int <------> memo_type   nubmer
 * 			default 1;   1. ���, 2. ȸ��, 3. ����, 4. ����, 5. �Ϲ�.. 
 * checked �Ϸ���� boolean <------> number(int)  1 �Ϸ�, 0 �̿Ϸ� 	
 * createdAt �������� Date <------> created_at date
 * 


CREATE TABLE TODOS 
(
  ID INT NOT NULL 
, MEMO VARCHAR2(145) 
, USER_NAME VARCHAR2(24) NOT NULL 
, MEMO_TYPE NUMBER(4) DEFAULT 1 
, CHECKED NUMBER(2) DEFAULT 0 
, CREATED_AT DATE 
, CONSTRAINT TODOS_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

COMMENT ON COLUMN TODOS.ID IS '������ȣ   ';

COMMENT ON COLUMN TODOS.MEMO IS '����(����)';

COMMENT ON COLUMN TODOS.USER_NAME IS '������̸�';

COMMENT ON COLUMN TODOS.MEMO_TYPE IS '���� ���� -  1. ���, 2. ȸ��, 3. ����, 4. ����, 5. �Ϲ�';

COMMENT ON COLUMN TODOS.CHECKED IS '�Ϸ���� - 1 �Ϸ�, 0 �̿Ϸ� 	';

COMMENT ON COLUMN TODOS.CREATED_AT IS '�������� ';




CREATE SEQUENCE TODO_SEQ INCREMENT BY 1 START WITH 1 MAXVALUE 20000 MINVALUE 1;

*/ 

public class Todo {
	public static final int DONE = 1; // 1 �Ϸ� true 
	public static final int UNDONE = 0; // 0 �̿Ϸ�  false
	public static final int MT_PROMISE = 1;
	public static final int MT_MEETING = 2;
	public static final int MT_PURCHASE = 3;
	public static final int MT_JOB = 4;
	public static final int MT_NORMAL = 5;
	public static final String[] MTYPES = {
		"", "1. ���", "2. ȸ��", "3. ����", "4. ����", "5. �Ϲ�"	
	};
	private int id;// ������ȣ      <------>   number   <<PK>>
	private String memo; // ����(����)     <------>  varchar2(145)
	private String userName; // ������̸�    <------>   user_name  varchar2(24)
	private int memoType; // ���� ����   <------> memo_type   nubmer
		//	default 1; 1. ���, 2. ȸ��, 3. ����, 4. ����, 5. �Ϲ�.. 
	private boolean checked;
		// �Ϸ����  <------> number(int)  1 �Ϸ�, 0 �̿Ϸ� 	
	private Date createdAt; // ��������?? (��ȣ? Ÿ�ϳ���?? ����? ��ȿ����?)
	
	public Todo() {}
	
	public Todo(String memo, String userName, int memoType) {
		super();
		this.memo = memo;
		this.userName = userName;
		this.memoType = memoType;
	}

	public Todo(int id, String memo, String userName, int memoType, boolean checked, Date createdAt) {
		super();
		this.id = id;
		this.memo = memo;
		this.userName = userName;
		this.memoType = memoType;
		this.checked = checked;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMemoType() {
		return memoType;
	}

	public void setMemoType(int memoType) {
		this.memoType = memoType;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", memo=" + memo + ", userName=" + userName + ", memoType=" + memoType + ", checked="
				+ checked + ", createdAt=" + createdAt + "]";
	}
	
	public String toList() {
		return (checked ? "[v] ":"[ ] ") + 
				"#" + id + " | " + memo + " | " 
				+ MTYPES[memoType]  + " | " 
				+ userName  + " | " 
				+ createdAt  + " | ";
//		return "Todo [id=" + id + ", memo=" +
//	memo + ", userName=" + userName + ", memoType="
//				+ memoType + ", checked="
//				+ checked + ", createdAt=" 
//				+ createdAt + "]";
	}
	
}