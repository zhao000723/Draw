package draw.ailingting.com.draw.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import draw.ailingting.com.draw.R;

/**
 * Created by zhaoyun on 2018/1/25.
 */

public class HomeFragment extends Fragment {
    Context mContext;
    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (null == mContext) {
            mContext = getActivity().getApplicationContext();
        }
        if (null == mView) {
            mView = inflater.inflate(R.layout.fragment_home, null);
        }
        initBanner();
        initToday();
        initHot();
        return mView;
    }

    //======================Banner======================
    RecyclerView mRecyclerBanner;

    private void initBanner() {
        if (null == mRecyclerBanner) {
            mRecyclerBanner = mView.findViewById(R.id.recycler_banner);
            mRecyclerBanner.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            mRecyclerBanner.setAdapter(new BannerAdapter());
            PagerSnapHelper helper = new PagerSnapHelper();
            helper.attachToRecyclerView(mRecyclerBanner);
            mRecyclerBanner.scrollToPosition(Integer.MAX_VALUE / 2);
        }
    }

    class BannerAdapter extends RecyclerView.Adapter<BannerViewHoder> {
        @Override
        public BannerViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.listitem_banner, parent, false);
            return new BannerViewHoder(inflate);
        }

        @Override
        public void onBindViewHolder(BannerViewHoder holder, int position) {
            holder.setImage(null);
        }

        @Override
        public int getItemCount() {
            return Integer.MAX_VALUE;
        }
    }

    class BannerViewHoder extends RecyclerView.ViewHolder {
        ImageView mCover;

        public BannerViewHoder(View itemView) {
            super(itemView);

            mCover = (ImageView) itemView;
        }

        void setImage(final String url) {
            mCover.setImageResource(R.drawable.a3);
        }
    }

    //======================Today======================
    RecyclerView mRecyclerToday;
    Button mButtonChange;

    private void initToday() {
        if (null == mButtonChange) {
            mButtonChange = mView.findViewById(R.id.button_change);
            mButtonChange.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

        if (null == mRecyclerToday) {
            mRecyclerToday = mView.findViewById(R.id.recycler_today);
            mRecyclerToday.setLayoutManager(new GridLayoutManager(mContext, 3));
            mRecyclerToday.setAdapter(new TodayAdapter());
        }
    }

    private class TodayAdapter extends RecyclerView.Adapter<TodayViewHolder> {

        @Override
        public TodayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.listitem_today, parent, false);
            return new TodayViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(TodayViewHolder holder, int position) {
            holder.setImage();
        }

        @Override
        public int getItemCount() {
            return 6;
        }
    }

    private class TodayViewHolder extends RecyclerView.ViewHolder {
        ImageView mCover;

        public TodayViewHolder(View itemView) {
            super(itemView);

            mCover = (ImageView) itemView;
        }

        public void setImage() {
            mCover.setImageResource(R.drawable.a1);
        }
    }

    //======================Hot======================
    RecyclerView mRecyclerTab;

    private void initHot() {
        if (null == mRecyclerTab) {
            mRecyclerTab = mView.findViewById(R.id.recycler_tab);
            mRecyclerTab.setLayoutManager(new LinearLayoutManager(mContext));
            mRecyclerTab.setAdapter(new HotAdapter());
        }
    }

    private class HotAdapter extends RecyclerView.Adapter<HotViewHolder> {

        @Override
        public HotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.listitem_tab, parent, false);
            return new HotViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(HotViewHolder holder, int position) {
            holder.setImage();
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class HotViewHolder extends RecyclerView.ViewHolder {
        ImageView mCover;

        public HotViewHolder(View itemView) {
            super(itemView);

            mCover = (ImageView) itemView;
        }

        public void setImage() {
            mCover.setImageResource(R.drawable.a2);
        }
    }
}
