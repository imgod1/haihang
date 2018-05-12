package com.imgod1.haihang.haihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.imgod1.haihang.haihang.ListResponse.ObjBean.DataListBean;
import com.yanzhenjie.nohttp.rest.AsyncRequestExecutor;
import com.yanzhenjie.nohttp.rest.Response;
import com.yanzhenjie.nohttp.rest.SimpleResponseListener;
import com.yanzhenjie.nohttp.rest.StringRequest;

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
                requestData();
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


    private String api = "https://bank.10044.cn/concentricPartner/getPackageInfo.do?generalizeType=addbill&packageStatus=50&pageNumber=1&pageSize=10&sort=8&time=1525772342237";

    private void requestData() {
        final StringRequest request = new StringRequest(api);
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

                    String log = Calendar.getInstance().getTime().toString();
                    if (null == resultDataListBean) {
                        log += ":无月标";
                    } else {
                        log += ":有月标";
                    }
                    txt_log.setText(txt_log.getText() + "\n" + log);
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }

                delay2NextRequest();
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

    private void delay2NextRequest() {
        btn_action.postDelayed(new Runnable() {
            @Override
            public void run() {
                requestData();
            }
        }, 5000);
    }
}
