package com.example.lab1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;

public class ActivityB extends AppCompatActivity {
    private Button dialogButton;
    private Button startcButton;
    private Button startaButton;
    private Button finishbButton;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null)
        {
            return;
        }
        stopUpdate stopupdate1;
        stopupdate1 = new stopUpdate(data.getStringExtra("from"));
        stopupdate1.update("%s.onStop()\n", "Stopped");
        stopupdate1.update("%s.onDestroy()\n", "Destroyed");
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
                i.putExtra("from","Activity B");
                startActivityForResult(i,0);
            }
        });
        startcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityB.this,ActivityC.class);
                i.putExtra("from","Activity B");
                startActivityForResult(i,0);
            }
        });
        finishbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra("from","Activity B");
                setResult(RESULT_OK,data);
                finish();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityB.this,Dialog.class);
                startActivityForResult(i,0);
            }
        });
    };

    @Override
    protected void onStop() {
        super.onStop();
        //ActivityA.instance.onCreate(ActivityA.toBeRefresh);
    }
}
