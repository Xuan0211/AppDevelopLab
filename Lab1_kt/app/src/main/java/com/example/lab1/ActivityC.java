package com.example.lab1_kt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ActivityC extends Activity {
    private Button dialogButton;
    private Button startbButton;
    private Button startaButton;
    private Button finishcButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        dialogButton = (Button) findViewById(R.id.c_dialog);
        startaButton = (Button) findViewById(R.id.c_start_a);
        startbButton = (Button) findViewById(R.id.c_start_b);
        finishcButton = (Button) findViewById(R.id.finish_c);
        startaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityC.this,ActivityA.class);
                startActivity(i);
            }
        });
        startbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityC.this,ActivityB.class);
                startActivity(i);
            }
        });
        finishcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog=new AlertDialog.Builder(ActivityC.this)
                        .setTitle(R.string.dialog)//设置标题
                        .setMessage(R.string.simple_dialog)//设置要显示的内容
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ActivityC.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();//销毁对话框
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ActivityC.this, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();//销毁对话框
                            }
                        }).create();//create（）方法创建对话框
                dialog.show();//显示对话框
            }
        });
    }
}
