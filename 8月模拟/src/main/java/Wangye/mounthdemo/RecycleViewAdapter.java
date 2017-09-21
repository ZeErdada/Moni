package Wangye.mounthdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * date 2017/9/20
 * functinn:
 */

public class RecycleViewAdapter extends RecyclerView.Adapter {
    private List<mebean.shutBean.UserBean> list;
    private List<String> listContent;
    private List<String> listImage;
    private Context context;
    private  List<mebean.shutBean.CommentfuckBean> listComment;


    public RecycleViewAdapter(List<mebean.shutBean.UserBean> list, List<String> listContent, List<String> listImage, Context context,List<mebean.shutBean.CommentfuckBean> listComment) {
        this.list = list;
        this.listContent = listContent;
        this.listImage = listImage;
        this.context = context;
        this.listComment=listComment;
    }

    //加载布局。
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        view = LayoutInflater.from(context).inflate(R.layout.item, null);
        viewHolder = new myViewHolder(view);
        return viewHolder;
    }

    //赋值
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        mebean.shutBean.UserBean bean = list.get(position);
        //        name, occupation, age, introduction;
        final myViewHolder myViewHolder = (myViewHolder) holder;
        myViewHolder.userName.setText("Name-" + (list.get(position).id + ""));
        myViewHolder.Content.setText(listContent.get(position));

        myViewHolder.time.setText(listComment.get(0).date);
        myViewHolder.userId.setText("Name-" + (listComment.get(0).userId + ":"));
        myViewHolder.content_pinglun.setText(listComment.get(0).content);

        myViewHolder.userId2.setText("Name-" + (listComment.get(1).userId + ":"));
        myViewHolder.content_pinglun2.setText(listComment.get(1).content);

        Glide.with(context).load(list.get(position).head).into(myViewHolder.userHead);
        Glide.with(context).load(listImage.get(position)).into(myViewHolder.image_1);



    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        TextView userName, Content,time,userId,content_pinglun,userId2,content_pinglun2;
        ImageView userHead, image_1, image_2, image_3;


        public myViewHolder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.userName);
            Content = (TextView) itemView.findViewById(R.id.Content);
            time = (TextView) itemView.findViewById(R.id.time);
            userId = (TextView) itemView.findViewById(R.id.userId);
            content_pinglun = (TextView) itemView.findViewById(R.id.content_pinglun);
            userId2 = (TextView) itemView.findViewById(R.id.userId2);
            content_pinglun2 = (TextView) itemView.findViewById(R.id.content_pinglun2);



            userHead = (ImageView) itemView.findViewById(R.id.userHead);
            image_1 = (ImageView) itemView.findViewById(R.id.image_1);
            image_2 = (ImageView) itemView.findViewById(R.id.image_2);
            image_3 = (ImageView) itemView.findViewById(R.id.image_3);


        }
    }
}


