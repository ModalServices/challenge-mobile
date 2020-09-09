package com.michelbarbosa.liveon.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.michelbarbosa.liveon.R;
import com.michelbarbosa.liveon.domain.OrderVehicle;

import java.util.List;

public class VehicleListAdapter extends RecyclerView.Adapter<VehicleListAdapter.VehicleHolder> {

    private final ItemClickListener mItemClickListener;
    private List<OrderVehicle> mOrderVehicleList;

    public VehicleListAdapter(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setOrderList(List<OrderVehicle> orderList){
        this.mOrderVehicleList = orderList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VehicleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liveon_button, parent, false);
        return new VehicleHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleHolder holder, int position) {
        OrderVehicle orderVehicle = mOrderVehicleList.get(position);
        holder.tvDesc.setText(orderVehicle.getSubmodel_name());
    }

    @Override
    public int getItemCount() {
        return mOrderVehicleList != null ? mOrderVehicleList.size() : 0;
    }

    private OrderVehicle getOrderVehicle(int adapterPosition) {
        return mOrderVehicleList.get(adapterPosition);
    }

    class VehicleHolder extends RecyclerView.ViewHolder{
        TextView tvDesc;
        ViewGroup itemArea;
        final ItemClickListener itemClickListener;

        VehicleHolder(final View itemView, final ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;
            tvDesc = itemView.findViewById(R.id.tv_liveon_bt_descr);
            itemArea = itemView.findViewById(R.id.cl_liveon_button);

            itemArea.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClick(getOrderVehicle(getAdapterPosition()));
                }
            });
        }
    }

    public interface ItemClickListener{
        void onClick(OrderVehicle orderVehicle);
    }

}
