package kjj.alibaba.com.kjj;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_anr;
    private Button btn_thread;
    private Button btn_handler;
    private Button btn_ui;

    private TextView tv_sss;

    private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        init();
    }

    private void init() {
        btn_anr = (Button) findViewById(R.id.btn_anr);
        btn_thread = (Button) findViewById(R.id.btn_thread);
        btn_handler = (Button) findViewById(R.id.btn_handler);
        btn_ui = (Button) findViewById(R.id.btn_ui);

        btn_anr.setOnClickListener(this);
        btn_thread.setOnClickListener(this);
        btn_handler.setOnClickListener(this);
        btn_ui.setOnClickListener(this);

        tv_sss = (TextView) findViewById(R.id.tv_sss);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_anr:     //模拟ANR崩溃
                SystemClock.sleep(30000);
                break;
            case R.id.btn_thread:  //模拟子线程更新数据
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tv_sss.setText("我是子线程，我不管，我要更新数据");
                    }
                }).start();
                break;

            case R.id.btn_handler: //子线程中用hanlder去更新数据
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv_sss.setText("我是子线程，我不管，我要用Handler机制去更新数据");
                    }
                });
                break;

            case R.id.btn_ui:  //runOnUiThread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_sss.setText("我是子线程，我不管，我要用runOnUiThread()方法去更新数据");
                    }
                });
                break;

        }
    }
}
