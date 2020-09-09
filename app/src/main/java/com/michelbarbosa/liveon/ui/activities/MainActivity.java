package com.michelbarbosa.liveon.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import com.michelbarbosa.liveon.R;
import com.michelbarbosa.liveon.data.orders.VehicleViewModel;
import com.michelbarbosa.liveon.data.user.UserViewModel;
import com.michelbarbosa.liveon.utils.UiUtil;

public class MainActivity extends BaseActivity {

    protected Toolbar toolbar;
    protected UserViewModel userViewModel;
    protected VehicleViewModel vehicleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSystemBars();
        userViewModel = new ViewModelProvider(MainActivity.this).get(UserViewModel.class);
        vehicleViewModel = new ViewModelProvider(MainActivity.this).get(VehicleViewModel.class);
    }

    private void setSystemBars() {
        UiUtil.setSystemComponent(this.getWindow());
    }

    public void setLayoutContent(int resourceContentView) {
        RelativeLayout dinamicContent = findViewById(R.id.content);
        View view = getLayoutInflater().inflate(resourceContentView, dinamicContent, false);
        dinamicContent.addView(view);
    }

    protected void setLightToolbarStyle() {
        setToolbar();
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorLight));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorLight));
    }

    protected void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setElevation(0);
        }
    }

    protected void setToolbarArrowBackPressed() {
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected void setToolbarTitle(int idResourceTitle) {
        if (toolbar != null) {
            if (idResourceTitle != 0) {
                TextView titleToolbar = findViewById(R.id.title_toolbar);
                titleToolbar.setText(idResourceTitle);
            }
        }
    }

    protected void advanceToVehicleListActivity(Context context) {
        Intent it = new Intent(context, VehicleListActivity.class);
        gotoActivity(it, context);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    protected void backToUserProfileActivity(Context context) {
        Intent it = new Intent(context, UserProfileActivity.class);
        gotoActivity(it, context);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void gotoActivity(Intent intent, Context context) {
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(intent);
    }

    protected void destroyApplication(Context context) {
        if (context != null) {
            clearData();
            userViewModel.fullWipe();
            finishAffinity();
        }
    }

}
