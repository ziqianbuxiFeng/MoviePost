package com.scujcc.moviepost;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>{
    /**
     * 创建一个具体的行，在这里是指电影行对应的ViewHolder类对象
     * @param viewGroup
     * @param viewType
     * @return
     */


    public interface OnItemClickListener{
        void onClick(int position);
    }
    public interface OnItemLongClickListener{
        void onClick(int position);
    }
    private OnItemClickListener listener;
    private OnItemLongClickListener longListener;
    public void setOnItemClickListener (OnItemClickListener listener){
        this.listener=listener;
    }
    public void  setOnItemLongClickListener (OnItemLongClickListener longListener){
        this.longListener=longListener;
    }


    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到电影行对应的xml，并将其“反析”出来（inflate）
        View container = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_view,parent,false);
        return new  MovieViewHolder(container);
    }

    /**
     * 填充每一行的内容，此事暂时硬编码，让所有行内容相同
     * @param holder
     * @param position
     */

    @Override
    public void onBindViewHolder(@NonNull final MovieViewHolder holder, final int position) {
        String name = MovieLab.get().getMovie(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (longListener !=null){
                    longListener.onClick(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longListener != null){
                    longListener.onClick(position);
                }
                return false;
            }
        });

    }

    /**
     * 表示列表行数此处暂时硬编码为5行
     * @return
     */

    @Override
    public int getItemCount() {
        return MovieLab.get().getSize();
    }

    //内部类,因碍于电影行布局XML对应
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView movieName;
        public MovieViewHolder(View container) {

            super(container);
            movieName = container.findViewById(R.id.movieName);

        }

        /**
         * 把传入的值显示到对应的控件上
         * @param movieName
         */
        public void bind(String movieName) {
            this.movieName.setText(movieName);
        }

    }
}
