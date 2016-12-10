package kjj.alibaba.com.kjj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_lin;
    private Button btn_rel;
    private Button btn_fra;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;

    private RelativeLayout rel;
    private LinearLayout lin;
    private FrameLayout fra;
    private ImageView iv_fra;
    private Button btn_message;//传递消息

    private Button btn_hand;

    public static final String TAG = "九大恶煞";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.i(TAG, "MainActivity......onCreate()方法");
        setContentView(R.layout.activity_main);
        initButton();//初始化按钮
        btn_one.setOnClickListener(new View.OnClickListener() { //第一种点击方式
            @Override
            public void onClick(View view) {
                btn_one.setText("第一种点击方式");
                btn_one.setTextColor(Color.RED);
            }
        });
        btn_two.setOnClickListener(this);//第二种点击方式
        btn_lin.setOnClickListener(this);
        btn_rel.setOnClickListener(this);
        btn_fra.setOnClickListener(this);
        iv_fra.setOnClickListener(this);
        btn_message.setOnClickListener(this);

    }

    private void initButton() {
        btn_lin = (Button) findViewById(R.id.btn_lin);
        btn_rel = (Button) findViewById(R.id.btn_rel);
        btn_fra = (Button) findViewById(R.id.btn_fra);
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        rel = (RelativeLayout) findViewById(R.id.rel);
        lin = (LinearLayout) findViewById(R.id.lin);
        fra = (FrameLayout) findViewById(R.id.fra);
        iv_fra = (ImageView) findViewById(R.id.iv_fra);
        btn_message = (Button) findViewById(R.id.btn_message);
        btn_hand = (Button) findViewById(R.id.btn_hand);
        btn_hand.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_two:
                btn_two.setText("第二种点击方式");
                btn_two.setTextColor(Color.BLUE);
                break;
            case R.id.btn_lin:
                hideView();
                lin.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_rel:
                hideView();
                rel.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_fra:
                hideView();
                fra.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_fra://设置点击绿色帧布局  变为红色
                iv_fra.setBackgroundColor(Color.RED);
                break;
            case R.id.btn_message://跳转
                intent = new Intent(this,MessageActivity.class);   //显示意图跳转
                startActivity(intent);
                break;
            case R.id.btn_hand://跳转
                intent = new Intent("com.alibaba.gaode");   //隐式意图跳转,清单文件配置
                startActivity(intent);
                break;

        }
    }

    public void threeClick(View view){
        btn_three.setText("第三种点击方式");
        btn_three.setTextColor(Color.GREEN);
    }

    private void hideView(){
        lin.setVisibility(View.GONE);
        fra.setVisibility(View.GONE);
        rel.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {//看见
        super.onStart();
        Log.i(TAG, "MainActivity......onStart()方法");
    }

    @Override
    protected void onResume() {//焦点
        super.onResume();
        Log.i(TAG, "MainActivity......onResume()方法");
    }

    @Override
    protected void onPause() {//失去焦点
        super.onPause();
        Log.i(TAG, "MainActivity......onPause()方法");
    }

    @Override
    protected void onStop() {//不可见
        super.onStop();
        Log.i(TAG, "MainActivity......onStop()方法");
    }

    @Override
    protected void onDestroy() {//摧毁
        super.onDestroy();
        Log.i(TAG, "MainActivity......onDestroy()方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "MainActivity......onRestart()方法");
    }
}
