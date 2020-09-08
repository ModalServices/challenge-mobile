package com.michelbarbosa.liveon.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import com.bumptech.glide.Glide;
import com.michelbarbosa.liveon.R;
import com.michelbarbosa.liveon.api.request.LiveOnRequest;
import com.michelbarbosa.liveon.api.request.LiveOnRequestContracts;
import com.michelbarbosa.liveon.api.response.UserProfileResponse;
import com.michelbarbosa.liveon.data.entities.OrderEntity;
import com.michelbarbosa.liveon.data.entities.StatusEntity;
import com.michelbarbosa.liveon.data.entities.UserEntity;
import com.michelbarbosa.liveon.domain.Order;
import com.michelbarbosa.liveon.domain.User;
import com.michelbarbosa.liveon.mapper.LiveOnMappers;
import com.michelbarbosa.liveon.ui.fragments.OrderStatusFragment;

import java.util.ArrayList;
import java.util.List;

import static com.michelbarbosa.liveon.ui.ConstantesUi.TOKEN_PREF;

public class UserProfileActivity extends BaseActivity implements LiveOnRequestContracts.UserProfileView, OrderStatusFragment.PerformPagination {

    private User mUser;

    private LiveOnRequestContracts.Presenter presenter = new LiveOnRequest(this);

    private TextView tvName, tvCity, tvOrder;
    private ImageView ivAvatar;
    private Button btBack, btNext, btSair;

    private FrameLayout container;
    private OrderStatusFragment fragment;

    private static int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutContent(R.layout.activity_userprofile);
        customizeToolbar();
        setViews();
        presenter.loadResponseToPersist(this, getIntent().getStringExtra(TOKEN_PREF));
    }

    @Override
    public void loadSuccess(UserProfileResponse response) {
        userViewModel.insertUser(response);
        setObservers();
    }

    @Override
    public void loadFailed(String error) {

    }

    private void setViews() {
        tvName = findViewById(R.id.tv_userProfile_fullname);
        tvCity = findViewById(R.id.tv_userProfile_city);
        ivAvatar = findViewById(R.id.iv_userProfile_avatar);
        container = findViewById(R.id.fl_userProfile_container);
        btBack = findViewById(R.id.bt_userProfile_back);
        btNext = findViewById(R.id.bt_userProfile_next);
        tvOrder = findViewById(R.id.tv_userProfile_order);
        btSair = findViewById(R.id.bt_userProfile_sair);
    }

    private void customizeToolbar() {
        setToolbar();
        setToolbarTitle(R.string.userProfileToolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorLight));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorLight));
    }

    private void setObservers() {
        if (userViewModel != null) {
            userViewModel.getUserEntity().observe(UserProfileActivity.this, new Observer<UserEntity>() {
                @Override
                public void onChanged(final UserEntity userEntity) {

                    userViewModel.getOrderList().observe(UserProfileActivity.this, new Observer<List<OrderEntity>>() {
                        @Override
                        public void onChanged(final List<OrderEntity> orderEntityList) {

                            userViewModel.getStatusList().observe(UserProfileActivity.this, new Observer<List<StatusEntity>>() {
                                @Override
                                public void onChanged(List<StatusEntity> statusEntityList) {
                                    mUser = LiveOnMappers.userEntityToDomain(userEntity, orderEntityList, statusEntityList);
                                    bindDataViews();
                                }
                            });

                        }
                    });

                }
            });
        }

    }

    private void bindDataViews() {
        tvName.setText(mUser.getFullname());
        tvCity.setText(new StringBuilder()
                .append(mUser.getCity())
                .append(" - ")
                .append(mUser.getUf()).toString());
        setImageAvatar(mUser.getUrlPictureAvatar());
        setFragment(mUser.getOrderList());
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentPage--;
                setControllerButtonFragment();
            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentPage++;
                setControllerButtonFragment();
            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                destroyApplication(UserProfileActivity.this);
            }
        });

    }

    private void setImageAvatar(String urlImage) {
        Glide.with(this)
                .load(urlImage)
                .circleCrop()
                .into(ivAvatar);
    }

    private void setFragment(List<Order> orderList){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        fragment = OrderStatusFragment.newInstance(
                new ArrayList<>(orderList));
        if (manager.findFragmentById(container.getId()) == null) {
            transaction.add(container.getId(), fragment);
        } else {
            transaction.replace(container.getId(), fragment);
        }
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    private void setControllerButtonFragment() {
        actionChangePage();
        tvOrder.setText(new StringBuilder().append("# ")
                .append(mUser.getOrderList().get(mCurrentPage).getOrderId())
                .append(" ")
                .append(mUser.getOrderList().get(mCurrentPage).getSubmodel_name()).toString());
        advancePage(mCurrentPage);
    }

    private void actionChangePage(){
        int totalPage = mUser.getOrderList().size() - 1;
        if(mCurrentPage < 1){
            mCurrentPage = 0;
            btBack.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_left_light_24dp));
            btNext.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp));
        } else if (mCurrentPage >= totalPage){
            btBack.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
            btNext.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_right_light_24dp));
            mCurrentPage = totalPage;
        } else {
            btBack.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_left_black_24dp));
            btNext.setBackground(getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp));
        }
    }

    @Override
    public void advancePage(int currentPage) {
        fragment.onAdvancePage(currentPage);
    }
}
