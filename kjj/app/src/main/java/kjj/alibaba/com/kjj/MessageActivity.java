package kjj.alibaba.com.kjj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "九大恶煞";

    private Button btn_normal;
    private Button btn_rela;
    private TextView tv_ret;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "MessageActivity......onCreate()方法");
        setContentView(R.layout.activity_message);
        initButton();
    }

    private void initButton() {
        btn_normal = (Button) findViewById(R.id.btn_normal);
        btn_rela = (Button) findViewById(R.id.btn_rela);
        tv_ret = (TextView) findViewById(R.id.tv_ret);
        btn_normal.setOnClickListener(this);
        btn_rela.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_rela:  //具有前后关系的Activity
                intent = new Intent(this, NewMessageActivity.class);
                intent.putExtra("m", "我曾经听人说过，当你不可以再拥有的时候。你唯一可以做的，就是让自己不要忘记。");
                startActivityForResult(intent, 0);
                break;

            case R.id.btn_normal:  //单纯传递参数
                intent = new Intent(this, NewMessageActivity.class);
                intent.putExtra("m", "我无所事事得厉害,所以感觉到时间的拖泥带水。但是奇怪的是,它虽然来得缓慢,但去的飞快。当我回头看看的时候,已经记不得昨天做的事情。最主要的原因是我昨天没有做什么事情。");
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (data.getStringExtra("s") != null)
                tv_ret.setText(data.getStringExtra("s"));
        }
    }

    @Override
    protected void onStart() {//看见
        super.onStart();
        Log.i(TAG, "MessageActivity......onStart()方法");
    }

    @Override
    protected void onResume() {//焦点
        super.onResume();
        Log.i(TAG, "MessageActivity......onResume()方法");
    }

    @Override
    protected void onPause() {//失去焦点
        super.onPause();
        Log.i(TAG, "MessageActivity......onPause()方法");
    }

    @Override
    protected void onStop() {//不可见
        super.onStop();
        Log.i(TAG, "MessageActivity......onStop()方法");
    }

    @Override
    protected void onDestroy() {//摧毁
        super.onDestroy();
        Log.i(TAG, "MessageActivity......onDestroy()方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "MessageActivity......onRestart()方法");
    }

}
