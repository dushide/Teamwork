package com.xiaoke.accountsoft.dao;

import dalvik.annotation.TestTargetClass;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TestInfoTool extends SQLiteOpenHelper{
	
	private static final int VERSION = 1;// �������ݿ�汾��
	private static final String DBNAME = "account.db";// �������ݿ���

	public TestInfoTool(Context context){// ���幹�캯��
	
		super(context, DBNAME, null, VERSION);// ��д����Ĺ��캯��
	}

	@Override
	public void onCreate(SQLiteDatabase db){// �������ݿ�
	
		OutaccountDAO.addTestInfo_Out(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
