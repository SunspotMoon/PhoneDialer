package com.example.administrator.phonedialer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_phone_num;
    private Button btn_call;
    private String telRegex = "[1][358]\\d{9}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_phone_num = (EditText) findViewById(R.id.et_phone_num);
        btn_call = (Button) findViewById(R.id.btn_call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击调用打电话功能
                String phoneNum = et_phone_num.getText().toString().trim();
                if (TextUtils.isEmpty(phoneNum)) {
                    /*注：EditText已在布局文件中指定为电话号码 故不再用正则表达式进行判定 android:inputType="phone"
                    */
                    Toast.makeText(MainActivity.this, "请输入电话号码", Toast.LENGTH_SHORT).show();
                } else {
                    if (phoneNum.matches(telRegex)) {
                        //调用系统打电话功能
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + phoneNum));
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
