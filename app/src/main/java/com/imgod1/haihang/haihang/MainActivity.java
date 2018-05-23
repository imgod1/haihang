package com.imgod1.haihang.haihang;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.imgod1.haihang.haihang.ListResponse.ObjBean.DataListBean;
import com.yanzhenjie.nohttp.rest.AsyncRequestExecutor;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;
import com.yanzhenjie.nohttp.rest.StringRequest;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }


    private void initEvent() {
        btn_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = btn_action.getText().toString();
                if (title.equals("开始监控")) {
                    btn_action.setText("正在监控");
                    requestData();
                } else {
                    btn_action.setText("开始监控");
                    request.cancel();
                    Toast.makeText(MainActivity.this, "监控已经停止", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Button btn_action;
    private ScrollView scrollView;
    private TextView txt_log;

    private Gson mGson;

    private void initView() {
        btn_action = findViewById(R.id.btn_action);
        scrollView = findViewById(R.id.scrollView);
        txt_log = findViewById(R.id.txt_log);
        mGson = new Gson();
    }


    private String api = "https://bank.10044.cn/concentricPartner/getPackageInfo.do?generalizeType=addbill&packageStatus=50&pageNumber=1&pageSize=10&sort=8";
    StringRequest request;

    private void requestData() {
        request = new StringRequest(api);
        AsyncRequestExecutor.INSTANCE.execute(0, request, new SimpleResponseListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                ListResponse listResponse = mGson.fromJson(response.get(), ListResponse.class);
                if (listResponse.getResultCode() == 50) {
                    DataListBean resultDataListBean = null;
                    List<DataListBean> list = listResponse.getObj().getDataList();
                    for (int i = 0; i < list.size(); i++) {
                        DataListBean dataListBean = list.get(i);
                        if (dataListBean.getTotalCycle() == 1 && dataListBean.getAvailableQuantity() > 0) {
                            resultDataListBean = dataListBean;
                            break;
                        }
                    }

                    String log = DateUtil.getFormatDate(Calendar.getInstance().getTime(), DateUtil.FORMAT_DATETIME);
                    if (null == resultDataListBean) {
                        log += ":无月标";
                        delay2NextRequest();
                    } else {
                        log += ":有月标";
                        playSound();
                    }
                    txt_log.setText(txt_log.getText() + "\n" + log);
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }

            }

            @Override
            public void onFailed(int what, Response<String> response) {
                // 请求失败。
                String log = response.getException().getMessage();
                txt_log.setText(txt_log.getText() + "\n" + log);
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                delay2NextRequest();
            }
        });
    }

    public static int DELAYMILLS = 1000;

    private void delay2NextRequest() {
        btn_action.postDelayed(new Runnable() {
            @Override
            public void run() {
                requestData();
            }
        }, DELAYMILLS);
    }


    private MediaPlayer myMediaPlayer;

    private void playSound() {
        AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int mVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC); // 获取当前音乐音量
        int maxVolume = mAudioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);// 获取最大声音
        mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0); // 设置为最大声音，可通过SeekBar更改音量大小

        AssetFileDescriptor fileDescriptor;
        try {
            if (null == myMediaPlayer) {
                fileDescriptor = MainActivity.this.getAssets().openFd("memeda.wav");
                myMediaPlayer = new MediaPlayer();
                myMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                myMediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),

                        fileDescriptor.getStartOffset(),

                        fileDescriptor.getLength());

                myMediaPlayer.prepare();
                myMediaPlayer.setLooping(true);
            }
            myMediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != myMediaPlayer) {
            myMediaPlayer.stop();
            myMediaPlayer.release();
        }
    }
}
