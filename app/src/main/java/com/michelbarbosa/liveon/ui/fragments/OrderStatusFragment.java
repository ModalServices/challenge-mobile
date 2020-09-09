package com.michelbarbosa.liveon.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.michelbarbosa.liveon.R;
import com.michelbarbosa.liveon.domain.Order;
import com.michelbarbosa.liveon.domain.Status;

import java.util.ArrayList;
import java.util.List;

import static com.michelbarbosa.liveon.ui.ConstantesUi.ORDER_LIST;

public class OrderStatusFragment extends Fragment {

    private ArrayList<Order> mOrderList;

    private PerformPagination mPerformPagination;

    private CheckBox cbStatus1, cbStatus2, cbStatus3 ,cbStatus4, cbStatus5, cbStatus6 ;
    private TextView tvStatus1, tvStatus2, tvStatus3 ,tvStatus4, tvStatus5, tvStatus6 ;
    private CheckBox[] checkBoxes;
    private TextView[] textViewes;
    private int[] checkResDraw;
    private int[] unCheckResDraw;

    public OrderStatusFragment(){

    }

    public static OrderStatusFragment newInstance(ArrayList<Order> orderList){
        OrderStatusFragment fragment = new OrderStatusFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ORDER_LIST, orderList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mOrderList = getArguments().getParcelableArrayList(ORDER_LIST);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orderstatus, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cbStatus1 = view.findViewById(R.id.cb_status1);
        cbStatus2 = view.findViewById(R.id.cb_status2);
        cbStatus3 = view.findViewById(R.id.cb_status3);
        cbStatus4 = view.findViewById(R.id.cb_status4);
        cbStatus5 = view.findViewById(R.id.cb_status5);
        cbStatus6 = view.findViewById(R.id.cb_status6);
        tvStatus1 = view.findViewById(R.id.tv_status1);
        tvStatus2 = view.findViewById(R.id.tv_status2);
        tvStatus3 = view.findViewById(R.id.tv_status3);
        tvStatus4 = view.findViewById(R.id.tv_status4);
        tvStatus5 = view.findViewById(R.id.tv_status5);
        tvStatus6 = view.findViewById(R.id.tv_status6);
        checkBoxes = new CheckBox[]{cbStatus1, cbStatus2, cbStatus3, cbStatus4, cbStatus5, cbStatus6};
        textViewes = new TextView[]{tvStatus1, tvStatus2, tvStatus3, tvStatus4, tvStatus5, tvStatus6};
        checkResDraw = new int[] {R.drawable.cb_checked1, R.drawable.cb_checked2,
                R.drawable.cb_checked2, R.drawable.cb_checked2, R.drawable.cb_checked2, R.drawable.cb_checked3};
        unCheckResDraw = new int[]{R.drawable.cb_unchecked1, R.drawable.cb_unchecked2,
                R.drawable.cb_unchecked2, R.drawable.cb_unchecked2, R.drawable.cb_unchecked2, R.drawable.cb_unchecked3};

        if(mOrderList.size() > 0)
            changeOrderSetViewData(mOrderList.get(0),
                    checkBoxes, textViewes, checkResDraw, unCheckResDraw);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof PerformPagination){
            mPerformPagination = (PerformPagination) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement PerformPagination");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPerformPagination = null;
    }

    private void changeOrderSetViewData(Order order, CheckBox[] checkBoxes,
                                        TextView[] textViews, int[] resDrawablesCheck,
                                        int[] resDrawblesUncheck){
        List<Status> statusList = order.getStatusList();
        if(!statusList.isEmpty()){
            int last = statusList.size();
            cleanOrderViewData(last);

            changeCbStatus(checkBoxes[0], resDrawablesCheck[0], resDrawblesUncheck[0], statusList.get(0).isChecked());
            textViews[0].setText(statusList.get(0).getLabel());

            for (int i = 1; i < last; i++){
                changeCbStatus(checkBoxes[i], resDrawablesCheck[i], resDrawblesUncheck[i], statusList.get(i).isChecked());
                textViews[i].setText(statusList.get(i).getLabel());
            }
            last = last - 1;
            changeCbStatus(checkBoxes[last], resDrawablesCheck[last], resDrawblesUncheck[last], statusList.get(last).isChecked());
            textViews[last].setText(statusList.get(last).getLabel());
        }
    }

    private void changeCbStatus(CheckBox cb, int resDrawableChecked,
            int resDrawableNoChecked, boolean isChecked){
        if (isChecked){
            cb.setButtonDrawable(resDrawableChecked);
        } else {
            cb.setButtonDrawable(resDrawableNoChecked);
        }
    }

    public void onAdvancePage(int currentPage){
        if(mPerformPagination != null){
            changeOrderSetViewData(mOrderList.get(currentPage),
                    checkBoxes, textViewes, checkResDraw, unCheckResDraw);
        }
    }

    public void cleanOrderViewData(int sizeList){
        for (int i = 0; i < sizeList; i++){
            changeCbStatus(checkBoxes[i], checkResDraw[i], unCheckResDraw[i], false);
            textViewes[i].setText("");
        }
    }

    public interface PerformPagination {
        void advancePage(int currentPage);
    }
}
