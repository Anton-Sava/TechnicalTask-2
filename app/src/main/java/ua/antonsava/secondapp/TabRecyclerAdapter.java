package ua.antonsava.secondapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Apple on 20.04.2016.
 */
public class TabRecyclerAdapter extends RecyclerView.Adapter<TabRecyclerAdapter.ViewHolder> {

    private List<TabRecycleViewData> mTabRecyclerList;
    private Context mContext;

    public TabRecyclerAdapter(Context context, List<TabRecycleViewData> tabList) {
        this.mContext = context;
        this.mTabRecyclerList = tabList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageIcon;
        TextView textTitle;
        TextView textAdress;
        TextView textData;
        TextView textDays;
        ImageView imageLike;
        LinearLayout linerLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageIcon = (ImageView) itemView.findViewById(R.id.mark);
            this.textTitle = (TextView) itemView.findViewById(R.id.titles);
            this.textAdress = (TextView) itemView.findViewById(R.id.adress);
            this.textData = (TextView) itemView.findViewById(R.id.data);
            this.textDays = (TextView) itemView.findViewById(R.id.days);
            this.imageLike = (ImageView) itemView.findViewById(R.id.like);
            this.linerLayout = (LinearLayout) itemView.findViewById(R.id.item_layout);
        }
    }

    @Override
    public TabRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TabRecyclerAdapter.ViewHolder holder, int position) {
        holder.imageIcon.setImageResource(mTabRecyclerList.get(position).getmMark());
        holder.textTitle.setText(mTabRecyclerList.get(position).getmTitle());
        holder.textAdress.setText(mTabRecyclerList.get(position).getmAdress());
        holder.textData.setText(mTabRecyclerList.get(position).getmData());
        holder.textDays.setText(mTabRecyclerList.get(position).getmDays());
        holder.imageLike.setImageResource(mTabRecyclerList.get(position).getmLike());

        holder.textTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i = new Intent(mContext, InformationActivity.class);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTabRecyclerList.size();
    }
}
