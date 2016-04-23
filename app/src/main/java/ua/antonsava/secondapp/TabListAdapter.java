package ua.antonsava.secondapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.OnClick;

/**
 * Created by Apple on 22.04.2016.
 */
public class TabListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<TabRecycleViewData> mTabListView;

    public TabListAdapter(Context context, List<TabRecycleViewData> tabListView) {

        mContext = context;
        mTabListView = tabListView;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    public TabListAdapter(WaitFragment waitFragment, List<TabRecycleViewData> tabListView) {
//
//    }

    @Override
    public Object getItem(int position) {
        return mTabListView.get(position);
    }



    @Override
    public int getCount() {
        return mTabListView.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

//    class ListViewHolder {
//
//        ImageView mMarks;
//        TextView mTitles;
//        TextView mAdress;
//        TextView mDate;
//        TextView mDays;
//        ImageView mLikes;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // ListViewHolder listViewHolder = new ListViewHolder();

        View view = convertView;
        if(view == null) {
       // mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = mLayoutInflater.inflate(R.layout.recycler_item, parent, false);
        }

        TabRecycleViewData data = getTabRecyclerViewData(position);

        ((ImageView) view.findViewById(R.id.mark)).setImageResource(data.mMark);
        ((ImageView) view.findViewById(R.id.like)).setImageResource(data.mLike);
        ((TextView) view.findViewById(R.id.titles)).setText(data.mTitle);
        ((TextView) view.findViewById(R.id.adress)).setText(data.mAdress);
        ((TextView) view.findViewById(R.id.data)).setText(data.mData);
        ((TextView) view.findViewById(R.id.days)).setText(data.mDays);

//        ImageView marks = (ImageView) view.findViewById(R.id.mark);
//        ImageView likes = (ImageView) view.findViewById(R.id.like);
//        TextView titles = (TextView) view.findViewById(R.id.titles);
//        TextView adress = (TextView) view.findViewById(R.id.adress);
//        TextView date = (TextView) view.findViewById(R.id.data);
//        TextView days = (TextView) view.findViewById(R.id.days);
//
//
//        listViewHolder.mMarks = marks;
//        listViewHolder.mTitles = titles;
//        listViewHolder.mAdress = adress;
//        listViewHolder.mDate = date;
//        listViewHolder.mDays = days;
//        listViewHolder.mLikes = likes;
//
//        view.setTag(listViewHolder);
//        listViewHolder = (ListViewHolder) view.getTag();
//
//        TabRecycleViewData data = mTabListView.get(position);
//
//        listViewHolder.mMarks.setImageResource(data.mMark);
//        listViewHolder.mTitles.setText(data.mTitle);
//        listViewHolder.mAdress.setText(data.mAdress);
//        listViewHolder.mDate.setText(data.mData);
//        listViewHolder.mDays.setText(data.mDays);
//        listViewHolder.mLikes.setImageResource(data.mLike);
//
//
//        TabRecycleViewData listData = getTabRecyclerViewData(position);
//



        return view;
    }

    private TabRecycleViewData getTabRecyclerViewData(int position) {
        return ((TabRecycleViewData) getItem(position));
    }

//    @Override
//    public int getViewTypeCount() {
//        return super.getViewTypeCount();
//    }
}
