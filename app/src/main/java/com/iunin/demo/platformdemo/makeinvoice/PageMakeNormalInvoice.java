package com.iunin.demo.platformdemo.makeinvoice;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.iunin.demo.platformdemo.R;
import com.iunin.demo.platformdemo.model.TaxGoodsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by copo on 17-11-15.
 */

public class PageMakeNormalInvoice extends Fragment implements View.OnClickListener{
    private List<TaxGoodsModel> goodsModels = new ArrayList<>();
    //查询到已储存的商品
    private List<TaxGoodsModel> savedGoodsModels = new ArrayList<>();
    private MaterialDialog materialDialog;
    private GoodsListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_make_normal_invoice,container,false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        RecyclerView goodsList = rootView.findViewById(R.id.goods_list);
        mAdapter = new GoodsListAdapter(goodsModels,getContext());
        goodsList.setAdapter(mAdapter);
        goodsList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.setOnaddGoodsListener(new GoodsListAdapter.OnaddGoodsListener() {
            @Override
            public void addGoods() {
                createGoodsListDialog();
            }
        });
    }

    private void createGoodsListDialog() {
        View rootView = getActivity().getLayoutInflater().inflate(R.layout.dialog_sel_good,null);
        Button cancelButton = rootView.findViewById(R.id.cancel);
        cancelButton.setOnClickListener(this);
        ListView listView = rootView.findViewById(R.id.id_good_list);
        listView.setAdapter(new SelectorGoodsListAdapter(getContext(),savedGoodsModels));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TaxGoodsModel model = savedGoodsModels.get(position);
                goodsModels.add(model);
                mAdapter.notifyDataSetChanged();
            }
        });

        materialDialog = new MaterialDialog.Builder(getContext()).customView(rootView,false).build();
        materialDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                materialDialog.cancel();
        }
    }
}
