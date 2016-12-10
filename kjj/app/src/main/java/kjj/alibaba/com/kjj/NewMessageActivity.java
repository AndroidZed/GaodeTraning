package kjj.alibaba.com.kjj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewMessageActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_shijian;
    public String s;
    private Button btn_yi;
    private Button btn_er;
    private Button btn_san;
    private Button btn_si;
    private LinearLayout ll_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);
        s = getIntent().getStringExtra("m");
        init();

        if (s.equals("我曾经听人说过，当你不可以再拥有的时候。你唯一可以做的，就是让自己不要忘记。")) {
            ll_btn.setVisibility(View.VISIBLE);
        } else {
            ll_btn.setVisibility(View.GONE);
        }

    }

    private void init() {
        tv_shijian = (TextView) findViewById(R.id.tv_shijian);
        tv_shijian.setText(s);
        btn_yi = (Button) findViewById(R.id.btn_yi);
        btn_er = (Button) findViewById(R.id.btn_er);
        btn_san = (Button) findViewById(R.id.btn_san);
        btn_si = (Button) findViewById(R.id.btn_si);
        btn_yi.setOnClickListener(this);
        btn_er.setOnClickListener(this);
        btn_san.setOnClickListener(this);
        btn_si.setOnClickListener(this);
        ll_btn = (LinearLayout) findViewById(R.id.ll_btn);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {

            case R.id.btn_yi:
                intent = new Intent();
                intent.putExtra("s", btn_yi.getText());
                setResult(0, intent);
                finish();
                break;
            case R.id.btn_er:
                intent = new Intent();
                intent.putExtra("s", btn_er.getText());
                setResult(0, intent);
                finish();
                break;

            case R.id.btn_san:
                intent = new Intent();
                intent.putExtra("s", btn_san.getText());
                setResult(0, intent);
                finish();
                break;

            case R.id.btn_si:
                intent = new Intent();
                intent.putExtra("s", btn_si.getText());
                setResult(0, intent);
                finish();
                break;

        }
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("s", "人愤怒的本质是对自身实力的不满");
        setResult(0, intent);
        finish();
    }
}
