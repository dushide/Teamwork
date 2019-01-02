package com.xiaoke.accountsoft.activity;

import com.xiaoke.accountsoft.dao.DBOpenHelper;
import com.xiaoke.accountsoft.dao.OutaccountDAO;
import com.xiaoke.accountsoft.dao.PwdDAO;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	EditText txtlogin;// 创建EditText对象
	Button btnlogin, btnclose,btnlogin_test;// 创建两个Button对象

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);// 设置布局文件

		txtlogin = (EditText) findViewById(R.id.txtLogin);// 获取密码文本框
		btnlogin = (Button) findViewById(R.id.btnLogin);// 获取登录按钮
		btnclose = (Button) findViewById(R.id.btnClose);// 获取取消按钮
		btnlogin_test = (Button) findViewById(R.id.btnLogin_fortest);//获取登录并添加测试数据按钮

		btnlogin.setOnClickListener(new OnClickListener() {// 为登录按钮设置监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, MainActivity.class);// 创建Intent对象
				PwdDAO pwdDAO = new PwdDAO(Login.this);// 创建PwdDAO对象
				// 判断是否有密码及是否输入了密码
				if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword()
						.isEmpty())
						&& txtlogin.getText().toString().isEmpty()) {
					startActivity(intent);// 启动主Activity
				} else {
					// 判断输入的密码是否与数据库中的密码一致
					if (pwdDAO.find().getPassword()
							.equals(txtlogin.getText().toString())) {
						startActivity(intent);// 启动主Activity
					} else {
						// 弹出信息提示
						Toast.makeText(Login.this, "请输入正确的密码！",
								Toast.LENGTH_SHORT).show();
					}
				}
				txtlogin.setText("");// 清空密码文本框
			}
		});

		btnclose.setOnClickListener(new OnClickListener() {// 为取消按钮设置监听事件
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();// 退出当前程序
			}
		});
		
		btnlogin_test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				DBOpenHelper helper = null;// 创建DBOpenHelper对象
				SQLiteDatabase db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
				// 执行添加支出信息操作
				int i=0;
//				while(i<5){
					db.execSQL(
						"insert into tb_outaccount (_id,money,time,type,address,mark) values (?,?,?,?,?,?)",
						new Object[] { i, i+100,
								"2017-01-0" + i + "" , "其他",
								"福州大学" + i + "", "无备注" });
//					i++;
//				}
				
				
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, MainActivity.class);// 创建Intent对象
				PwdDAO pwdDAO = new PwdDAO(Login.this);// 创建PwdDAO对象
				// 判断是否有密码及是否输入了密码
				if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword()
						.isEmpty())
						&& txtlogin.getText().toString().isEmpty()) {
					startActivity(intent);// 启动主Activity
				} else {
					// 判断输入的密码是否与数据库中的密码一致
					if (pwdDAO.find().getPassword()
							.equals(txtlogin.getText().toString())) {
						startActivity(intent);// 启动主Activity
					} else {
						// 弹出信息提示
						Toast.makeText(Login.this, "请输入正确的密码！",
								Toast.LENGTH_SHORT).show();
					}
				}
				txtlogin.setText("");// 清空密码文本框
			}
		});
	}
}
