package com.youth4work.CGPSC_2023.ui.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.Button;


import com.youth4work.CGPSC_2023.R;
import com.youth4work.CGPSC_2023.ui.base.BaseActivity;


public class MockTestRulesActivity extends BaseActivity {
    Button btnStartMockTest;
    static int testId;

    public static void show(@NonNull Context fromActivity, int testid) {
        testId = testid;
        Intent intent = new Intent(fromActivity, MockTestRulesActivity.class);
        fromActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_test_rules);
        btnStartMockTest = findViewById(R.id.btn_start_mock_test);
        btnStartMockTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MockTestActivity.show(MockTestRulesActivity.this, testId, 1);
            }
        });
    }
}
