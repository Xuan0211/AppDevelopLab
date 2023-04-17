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

public class ActivityC extends AppCompatActivity {
    private Button dialogButton;
    private Button startbButton;
    private Button startaButton;
    private Button finishcButton;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null)
        {
            return;
        }
        stopUpdate stopupdate;
        stopupdate = new stopUpdate(data.getStringExtra("from"));
        stopupdate.update("%s.onStop()\n", "Stopped");
        stopupdate.update("%s.onDestroy()\n", "Destroyed");
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        String from = getIntent().getStringExtra("from");
        if(from!=null)
        {
            stopUpdate stopupdate;
            stopupdate = new stopUpdate((from));
            stopupdate.update("%s.onStop()\n", "Stopped");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityc);
        getLifecycle().addObserver(new myObserver(getString(R.string.C_text),
                findViewById(R.id.method_list),
                findViewById(R.id.status)));
        dialogButton = (Button) findViewById(R.id.c_dialog);
        startaButton = (Button) findViewById(R.id.c_start_a);
        startbButton = (Button) findViewById(R.id.c_start_b);
        finishcButton = (Button) findViewById(R.id.finish_c);
        startaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityC.this,ActivityA.class);
                i.putExtra("from","Activity C");
                startActivityForResult(i,0);
            }
        });
        startbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityC.this,ActivityB.class);
                i.putExtra("from","Activity C");
                startActivityForResult(i,0);
            }
        });
        finishcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("from","Activity C");
                setResult(RESULT_OK,data);
                finish();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopUpdate stopupdate;
                stopupdate = new stopUpdate("Activity C");
                stopupdate.update("%s.onPause()\n", "Paused");
                AlertDialog dialog=new AlertDialog.Builder(ActivityC.this)
                        .setTitle(R.string.dialog)//设置标题
                        .setMessage(R.string.simple_dialog)//设置要显示的内容
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(ActivityC.this, "点击了确定的按钮", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();//销毁对话框
                                stopUpdate stopupdate;
                                stopupdate = new stopUpdate("Activity C");
                                stopupdate.update("%s.onResume()\n", "Resumed");
                            }
                        }).create();//create（）方法创建对话框
                dialog.show();//显示对话框
            }
        });
    }
}
