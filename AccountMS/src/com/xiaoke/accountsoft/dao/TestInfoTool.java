package com.xiaoke.accountsoft.dao;

import dalvik.annotation.TestTargetClass;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TestInfoTool extends SQLiteOpenHelper{
	
	private static final int VERSION = 1;// 定义数据库版本号
	private static final String DBNAME = "account.db";// 定义数据库名

	public TestInfoTool(Context context){// 定义构造函数
	
		super(context, DBNAME, null, VERSION);// 重写基类的构造函数
	}

	@Override
	public void onCreate(SQLiteDatabase db){// 创建数据库
	
		OutaccountDAO.addTestInfo_Out(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

}
