package com.fkm.recyclerviewmultitype.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.fkm.recyclerviewmultitype.R;
import com.fkm.recyclerviewmultitype.model.FilmReviewInfo;

import java.util.List;

public class FilmReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<FilmReviewInfo> mList;
    private FilmReviewInfo data;
    private OnItemClickListener mOnItemClickListener;

    private static int VIEW_TYPE_1 = 1;
    private static int VIEW_TYPE_2 = 2;

    public FilmReviewAdapter(Context context, List<FilmReviewInfo> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position).getCoverImgType() == 2) {
            return VIEW_TYPE_2;
        }
        return VIEW_TYPE_1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_film_review2, parent, false);
            ViewHolder2 holder = new ViewHolder2(view);
            return holder;
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_film_review1, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        data = mList.get(position);
        if (holder instanceof ViewHolder) {
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.movie_bg)
                    .error(R.drawable.movie_bg);
            Glide.with(mContext).load(data.getCoverImg()).apply(options).into(((ViewHolder) holder).iv_cover);
            ((ViewHolder) holder).tv_author.setText(data.getAuthor());
            ((ViewHolder) holder).tv_published_date.setText(data.getPublishedDate());
            ((ViewHolder) holder).tv_title.setText(data.getTitle());
        } else if (holder instanceof ViewHolder2) {
            RequestOptions options = new RequestOptions()
                    .placeholder(R.drawable.movie_bg)
                    .error(R.drawable.movie_bg);
            Glide.with(mContext).load(data.getCoverImg()).apply(options).into(((ViewHolder2) holder).iv_cover);
            ((ViewHolder2) holder).tv_author.setText(data.getAuthor());
            ((ViewHolder2) holder).tv_published_date.setText(data.getPublishedDate());
            ((ViewHolder2) holder).tv_title.setText(data.getTitle());
        }

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_cover;
        private TextView tv_author;
        private TextView tv_published_date;
        private TextView tv_title;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_author = (TextView) itemView.findViewById(R.id.tv_author);
            tv_published_date = (TextView) itemView.findViewById(R.id.tv_published_date);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {

        private ImageView iv_cover;
        private TextView tv_author;
        private TextView tv_published_date;
        private TextView tv_title;

        public ViewHolder2(View itemView) {
            super(itemView);
            iv_cover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tv_author = (TextView) itemView.findViewById(R.id.tv_author);
            tv_published_date = (TextView) itemView.findViewById(R.id.tv_published_date);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);

    }

    public void setItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

}
