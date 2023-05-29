package com.youth4work.CGPSC_2023.ui.quiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.analytics.Tracker;
import com.youth4work.CGPSC_2023.PrepApplication;

import com.youth4work.CGPSC_2023.R;
import com.youth4work.CGPSC_2023.network.model.Subject;
import com.youth4work.CGPSC_2023.ui.base.BaseActivity;
import com.youth4work.CGPSC_2023.ui.views.PrepButton;
import com.youth4work.CGPSC_2023.util.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestRulesActivity extends BaseActivity {

    public static final String ATTEMPTED_DATE = "attempted_date";
    public static final String SUBJECT_ID = "subject_id";
    public static final String CATEGORY_ID = "category_id";

    @Nullable
    @BindView(R.id.lblPaymentDescription)
    TextView lblPaymentDescription;
    @Nullable
    @BindView(R.id.lblPaymentDesc)
    TextView lblPaymentDescription1;
    @Nullable
    @BindView(R.id.rlPlaceHolderrule)
    RelativeLayout rlPlaceHolderrule;
    @Nullable
    @BindView(R.id.scrlHolder)
    ScrollView scrlHolder;
    @Nullable
    @BindView(R.id.btn_start_test)
    PrepButton btnStartTest;

    private int mAttemptedToday = 0, mAttemptedTotal = 0;
    private long mAttemptedDate;
    private int mSubjectId;
    static List<Subject> mSubjectList;
    private static int TestType=0;
    private Tracker mTracker;
    private static int testId;
    public static void show(@NonNull Context fromActivity,int testid,int testtype) {
        testId=testid;
        TestType=testtype;
        Intent intent = new Intent(fromActivity, TestRulesActivity.class);
        fromActivity.startActivity(intent);

    }
   /* public static void show(@NonNull Context fromActivity, int subjectId, @NonNull Date currentSelectedDate,Boolean flag) {
        Intent intent = new Intent(fromActivity, TestRulesActivity.class);
        intent.putExtra(SUBJECT_ID, subjectId);
        intent.putExtra("isSubject",flag);
        if (currentSelectedDate != null) {
            intent.putExtra(ATTEMPTED_DATE, currentSelectedDate.getTime());
        }
        fromActivity.startActivity(intent);
    }
    public static void show(@NonNull Context fromActivity, int subjectId, @NonNull Date currentSelectedDate, Boolean flag, List<Subject> mSubjectList1) {
        Intent intent = new Intent(fromActivity, TestRulesActivity.class);
        intent.putExtra(SUBJECT_ID, subjectId);
        intent.putExtra("isSubject",flag);
        if (currentSelectedDate != null) {
            intent.putExtra(ATTEMPTED_DATE, currentSelectedDate.getTime());
        }
        mSubjectList=mSubjectList1;
        fromActivity.startActivity(intent);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rules);
        ButterKnife.bind(this);

        PrepApplication application = (PrepApplication) getApplication();
        mTracker = application.getDefaultTracker();
        Constants.sendScreenImageName(mTracker, "Test Rules");

        setupButtons();

    }

    private void setupButtons() {
        if (mAttemptedDate != -1) {
            if (mAttemptedToday > 0 && mAttemptedToday < 20 && mAttemptedTotal <= 5000) {
                btnStartTest.setText("Resume Test");
            }
        } else {
            lblPaymentDescription1.setText(R.string.practice_instructions);
            btnStartTest.setText("Practice Test");
        }
    }

    @OnClick(R.id.btn_start_test)
    public void onClick() {
        DailyTestActivity.show(this,testId,TestType);
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
