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
	EditText txtlogin;// ����EditText����
	Button btnlogin, btnclose,btnlogin_test;// ��������Button����

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);// ���ò����ļ�

		txtlogin = (EditText) findViewById(R.id.txtLogin);// ��ȡ�����ı���
		btnlogin = (Button) findViewById(R.id.btnLogin);// ��ȡ��¼��ť
		btnclose = (Button) findViewById(R.id.btnClose);// ��ȡȡ����ť
		btnlogin_test = (Button) findViewById(R.id.btnLogin_fortest);//��ȡ��¼����Ӳ������ݰ�ť

		btnlogin.setOnClickListener(new OnClickListener() {// Ϊ��¼��ť���ü����¼�
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, MainActivity.class);// ����Intent����
				PwdDAO pwdDAO = new PwdDAO(Login.this);// ����PwdDAO����
				// �ж��Ƿ������뼰�Ƿ�����������
				if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword()
						.isEmpty())
						&& txtlogin.getText().toString().isEmpty()) {
					startActivity(intent);// ������Activity
				} else {
					// �ж�����������Ƿ������ݿ��е�����һ��
					if (pwdDAO.find().getPassword()
							.equals(txtlogin.getText().toString())) {
						startActivity(intent);// ������Activity
					} else {
						// ������Ϣ��ʾ
						Toast.makeText(Login.this, "��������ȷ�����룡",
								Toast.LENGTH_SHORT).show();
					}
				}
				txtlogin.setText("");// ��������ı���
			}
		});

		btnclose.setOnClickListener(new OnClickListener() {// Ϊȡ����ť���ü����¼�
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();// �˳���ǰ����
			}
		});
		
		btnlogin_test.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				DBOpenHelper helper = null;// ����DBOpenHelper����
				SQLiteDatabase db = helper.getWritableDatabase();// ��ʼ��SQLiteDatabase����
				// ִ�����֧����Ϣ����
				int i=0;
//				while(i<5){
					db.execSQL(
						"insert into tb_outaccount (_id,money,time,type,address,mark) values (?,?,?,?,?,?)",
						new Object[] { i, i+100,
								"2017-01-0" + i + "" , "����",
								"���ݴ�ѧ" + i + "", "�ޱ�ע" });
//					i++;
//				}
				
				
				// TODO Auto-generated method stub
				Intent intent = new Intent(Login.this, MainActivity.class);// ����Intent����
				PwdDAO pwdDAO = new PwdDAO(Login.this);// ����PwdDAO����
				// �ж��Ƿ������뼰�Ƿ�����������
				if ((pwdDAO.getCount() == 0 || pwdDAO.find().getPassword()
						.isEmpty())
						&& txtlogin.getText().toString().isEmpty()) {
					startActivity(intent);// ������Activity
				} else {
					// �ж�����������Ƿ������ݿ��е�����һ��
					if (pwdDAO.find().getPassword()
							.equals(txtlogin.getText().toString())) {
						startActivity(intent);// ������Activity
					} else {
						// ������Ϣ��ʾ
						Toast.makeText(Login.this, "��������ȷ�����룡",
								Toast.LENGTH_SHORT).show();
					}
				}
				txtlogin.setText("");// ��������ı���
			}
		});
	}
}
