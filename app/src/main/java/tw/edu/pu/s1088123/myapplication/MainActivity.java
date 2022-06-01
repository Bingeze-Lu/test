package tw.edu.pu.s1088123.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import tw.edu.pu.s1088123.myapplication.dao.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void reg(View view){

        startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
}
    public void login(View view){

        EditText EditTextname = (EditText)findViewById(R.id.name);
        EditText EditTextpassword = (EditText)findViewById(R.id.password);

        new Thread(){
            @Override
            public void run() {

                UserDao userDao = new UserDao();

                boolean aa = userDao.login(EditTextname.getText().toString(),EditTextpassword.getText().toString());
                int msg = 0;
                if(aa){
                    msg = 1;
                }

                hand1.sendEmptyMessage(msg);


            }
        }.start();


    }
    final Handler hand1 = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {

            if(msg.what == 1)
            {
                Toast.makeText(getApplicationContext(),"登入成功",Toast.LENGTH_LONG).show();

            }
            else
            {
                Toast.makeText(getApplicationContext(),"登入失敗",Toast.LENGTH_LONG).show();
            }
        }
    };
}