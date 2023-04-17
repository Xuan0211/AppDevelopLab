package com.example.lab1;

import static android.app.PendingIntent.getActivity;
import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class ActivityA extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private Button dialogButton;
    private Button startbButton;
    private Button startcButton;
    private Button finishaButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitya);
        getLifecycle().addObserver(new myObserver(getString(R.string.A_text),
                findViewById(R.id.method_list),
                findViewById(R.id.status)));
        dialogButton = (Button) findViewById(R.id.a_dialog);
        startbButton = (Button) findViewById(R.id.a_start_b);
        startcButton = (Button) findViewById(R.id.a_start_c);
        finishaButton = (Button) findViewById(R.id.finish_a);
        startbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityA.this,ActivityB.class);
                startActivity(i);
            }
        });
        startcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityA.this,ActivityC.class);
                startActivity(i);
               // startActivityForResult(i);
            }
        });
        finishaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog=new AlertDialog.Builder(ActivityA.this)
                        .setTitle(R.string.dialog)//设置标题
                        .setMessage(R.string.simple_dialog)//设置要显示的内容
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ActivityA.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();//销毁对话框
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ActivityA.this, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();//销毁对话框
                            }
                        }).create();//create（）方法创建对话框
                dialog.show();//显示对话框
            }
        });
        Log.e(TAG,"MyTest:Aoncreate");
    };

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"MyTest:AonPause");
    };

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"MyTest:AonStop");
    }
}
