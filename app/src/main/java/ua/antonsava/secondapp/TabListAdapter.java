package ua.antonsava.secondapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Apple on 22.04.2016.
 */
public class TabListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<TabRecycleViewData> mTabListView;

   public TabListAdapter(Context context, List<TabRecycleViewData>tabListView) {
        mContext = context;
        mTabListView = tabListView;
        mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    public TabListAdapter(WaitFragment waitFragment, List<TabRecycleViewData> tabListView) {
//
//    }

    @Override
    public int getCount() {
        return mTabListView.size();
    }

    @Override
    public Object getItem(int position) {
        return mTabListView.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null) {
            view = mLayoutInflater.inflate(R.layout.recycler_item, parent, false);
        }

        TabRecycleViewData listData = getTabRecyclerViewData(position);

        ((ImageView) view.findViewById(R.id.mark)).setImageResource(listData.mMark);
        ((TextView) view.findViewById(R.id.title)).setText(listData.mTitle);
        ((TextView) view.findViewById(R.id.adress)).setText(listData.mAdress);
        ((TextView) view.findViewById(R.id.data)).setText(listData.mData);
        ((TextView) view.findViewById(R.id.days)).setText(listData.mDays);
        ((ImageView) view.findViewById(R.id.like)).setImageResource(listData.mLike);

        return view;
    }

    private TabRecycleViewData getTabRecyclerViewData(int position) {
        return ((TabRecycleViewData) getItem(position));
    }
}
