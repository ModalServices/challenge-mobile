package com.michelbarbosa.liveon.ui.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.michelbarbosa.liveon.R;
import com.michelbarbosa.liveon.api.request.LiveOnRequest;
import com.michelbarbosa.liveon.api.request.LiveOnRequestContracts;
import com.michelbarbosa.liveon.api.response.OrderResponse;
import com.michelbarbosa.liveon.data.entities.OrderVehicleEntity;
import com.michelbarbosa.liveon.domain.OrderVehicle;
import com.michelbarbosa.liveon.mapper.LiveOnMappers;
import com.michelbarbosa.liveon.ui.adapters.VehicleListAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.michelbarbosa.liveon.ui.ConstantesUi.TOKEN_PREF;

public class VehicleListActivity extends MainActivity implements LiveOnRequestContracts.OrderListView {

    private List<OrderVehicle> orderVehicleList;

    private VehicleListAdapter adapter;
    private VehicleListAdapter.ItemClickListener itemClickListener;
    private LiveOnRequestContracts.Presenter presenter = new LiveOnRequest(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutContent(R.layout.activity_vehicle_list);
        toolbarSettings();
        setOperationList();
        setViews();
        setObservers();
        if(orderVehicleList == null){
            presenter.loadOrdersResponse(this, sharedPreferences.getString(TOKEN_PREF, ""));
        }
    }

    private void toolbarSettings() {
        setLightToolbarStyle();
        setToolbarTitle(R.string.assinaturas);
        setToolbarArrowBackPressed();
    }

    private void setViews() {
        RecyclerView rvVehicleList = findViewById(R.id.rv_vehicle_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new VehicleListAdapter(itemClickListener);
        rvVehicleList.setLayoutManager(layoutManager);
        rvVehicleList.setAdapter(adapter);
    }

    @Override
    public void loadSuccess(List<OrderResponse> response) {
        vehicleViewModel.insertOrderVehicle(response);
        setObservers();
    }

    @Override
    public void loadFailed(String error) {
    }

    private void setObservers() {
        vehicleViewModel.getOrderVEntity().observe(this, new Observer<List<OrderVehicleEntity>>() {
            @Override
            public void onChanged(List<OrderVehicleEntity> orderVEntityList) {
                orderVehicleList = new ArrayList<>(LiveOnMappers.orderEntityToOrderVehicleEntity(orderVEntityList));
                adapter.setOrderList(orderVehicleList);
            }
        });
    }

    private void setOperationList() {
        itemClickListener = new VehicleListAdapter.ItemClickListener() {
            @Override
            public void onClick(OrderVehicle orderVehicle) {
                Toast.makeText(VehicleListActivity.this, "Order: " + orderVehicle.getSubmodel_name(), Toast.LENGTH_SHORT).show();
            }
        };
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backToUserProfileActivity(this);
    }
}
