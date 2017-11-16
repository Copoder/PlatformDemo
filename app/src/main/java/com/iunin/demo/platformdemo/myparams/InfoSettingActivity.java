package com.iunin.demo.platformdemo.myparams;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.iunin.demo.platformdemo.R;
import com.iunin.demo.platformdemo.ui.widgit.AutoCompleteTextViewWithDeleteView;
import com.iunin.demo.platformdemo.utils.ConfigUtil;

import static com.iunin.demo.platformdemo.utils.Constans.KPZDBS;
import static com.iunin.demo.platformdemo.utils.Constans.NSRSBH;

/**
 * Created by copo on 17-11-15.
 */

public class InfoSettingActivity extends AppCompatActivity implements View.OnClickListener{
    private ConfigUtil configUtil;
    private AutoCompleteTextViewWithDeleteView act_narsbh;
    private AutoCompleteTextViewWithDeleteView act_kpzdbs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        configUtil = new ConfigUtil(InfoSettingActivity.this);
        initView();
    }

    private void initView() {
        act_narsbh = findViewById(R.id.edt_nasrsbh);
        act_kpzdbs = findViewById(R.id.edt_kpzdbs);
        Button saveButton = findViewById(R.id.save_params);
        saveButton.setOnClickListener(this);
        setParams();
    }

    private void setParams() {
        act_narsbh.setText(configUtil.getString(NSRSBH,""));
        act_kpzdbs.setText(configUtil.getString(KPZDBS,""));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save_params:
                saveParams();
                break;
        }
    }

    private void saveParams() {
        configUtil.putString(NSRSBH,act_narsbh.getText().toString());
        configUtil.putString(KPZDBS,act_kpzdbs.getText().toString());
    }
}
