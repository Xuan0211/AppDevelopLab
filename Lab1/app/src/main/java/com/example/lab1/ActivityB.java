package com.example.lab1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {
    private Button dialogButton;
    private Button startcButton;
    private Button startaButton;
    private Button finishbButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityb);
        getLifecycle().addObserver(new myObserver(getString(R.string.B_text),
                findViewById(R.id.method_list),
                findViewById(R.id.status)));
        dialogButton = (Button) findViewById(R.id.b_dialog);
        startaButton = (Button) findViewById(R.id.b_start_a);
        startcButton = (Button) findViewById(R.id.b_start_c);
        finishbButton = (Button) findViewById(R.id.finish_b);
        startaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityB.this,ActivityA.class);
                startActivity(i);
            }
        });
        startcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityB.this,ActivityC.class);
                startActivity(i);
            }
        });
        finishbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog dialog=new AlertDialog.Builder(ActivityB.this)
                        .setTitle(R.string.dialog)//设置标题
                        .setMessage(R.string.simple_dialog)//设置要显示的内容
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ActivityB.this, "点击了取消按钮", Toast.LENGTH_SHORT).show();
                                dialogInterface.dismiss();//销毁对话框
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ActivityB.this, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();//销毁对话框
                            }
                        }).create();//create（）方法创建对话框
                dialog.show();//显示对话框
            }
        });
    }
}
