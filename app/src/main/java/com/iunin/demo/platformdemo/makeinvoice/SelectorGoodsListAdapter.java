package com.iunin.demo.platformdemo.makeinvoice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iunin.demo.platformdemo.R;
import com.iunin.demo.platformdemo.model.TaxGoodsModel;
import com.iunin.demo.platformdemo.ui.base.ArrayWapperAdapter;
import com.iunin.demo.platformdemo.ui.base.ViewHolder;

import java.util.List;

/**
 * Created by copo on 17-11-16.
 */

public class SelectorGoodsListAdapter extends ArrayWapperAdapter<TaxGoodsModel> {
    public SelectorGoodsListAdapter(Context context, List<TaxGoodsModel> models) {
        super(context, models);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = getInflater().inflate(R.layout.item_sel_item,null);
        }
        TextView id_good_name = ViewHolder.get(convertView, R.id.id_good_name);
        TextView id_good_price = ViewHolder.get(convertView, R.id.id_good_price); //含税单价
        TextView id_good_discount = ViewHolder.get(convertView, R.id.id_good_discount);
        TextView id_good_tax = ViewHolder.get(convertView, R.id.id_good_tax);

        if (position >= getCount()) {
            position = getCount() - 1;
        }
        TaxGoodsModel model = getItem(position);
        id_good_name.setText(model.spmc);
        id_good_price.setText(model.dj.toString());
        id_good_discount.setText(model.disCount);
        id_good_tax.setText(model.sl.toString()+"%");

        return convertView;
    }
}
