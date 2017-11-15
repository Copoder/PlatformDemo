package com.iunin.demo.platformdemo.makeinvoice;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iunin.demo.platformdemo.R;
import com.iunin.demo.platformdemo.model.TaxGoodsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by copo on 17-11-15.
 */

public class PageMakeRollInvoce extends Fragment {
    private List<TaxGoodsModel> goodsModels = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_make_roll_invoice,container,false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        RecyclerView goodList = rootView.findViewById(R.id.goods_list);
        GoodsListAdapter mAdapter = new GoodsListAdapter(goodsModels,getContext());
        goodList.setAdapter(mAdapter);
        goodList.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
