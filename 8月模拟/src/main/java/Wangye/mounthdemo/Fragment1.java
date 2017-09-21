package Wangye.mounthdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * date 2017/9/20
 * functinn:
 */

public class Fragment1 extends Fragment {
    private View view;
    private RecyclerView mMyRec;
    private String path = "http://139.196.140.118:8080/get/%7B%22%5B%5D%22:%7B%22page%22:0,%22count%22:10,%22Moment%22:%7B%22content$%22:%22%2525a%2525%22%7D,%22User%22:%7B%22id@%22:%22%252FMoment%252FuserId%22,%22@column%22:%22id,name,head%22%7D,%22Comment%5B%5D%22:%7B%22count%22:2,%22Comment%22:%7B%22momentId@%22:%22%5B%5D%252FMoment%252Fid%22%7D%7D%7D%7D";
    private LinearLayoutManager linearLayoutManager;
    private List<mebean.shutBean.UserBean> listUser;
    private RecycleViewAdapter adpter;
    private int page=0;
    private List<String> listContent;
    private List<String> listImage;
    private List<mebean.shutBean.CommentfuckBean> listComment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        initView(view);
        initData();
        OkHttpManager.getInstance().asyncJsonStringByURL(path, new OkHttpManager.Func1() {
            @Override
            public void onResponse(String result) {

                listUser = new ArrayList<mebean.shutBean.UserBean>();
                listContent = new ArrayList<String>();
                listImage = new ArrayList<String>();
                listComment = new ArrayList<>();
                Gson gson = new Gson();
                mebean myBean = gson.fromJson(result, mebean.class);

                for (int i = 0; i < myBean.fuck.size(); i++) {
                    listUser.add(myBean.fuck.get(i).User);
                    listContent.add(myBean.fuck.get(i).Moment.content);
                    listComment = myBean.fuck.get(i).Commentfuck;
                    listImage.add(myBean.fuck.get(i).Moment.pictureList.get(0));


                }


                Toast.makeText(getActivity(), listComment.toString(), Toast.LENGTH_SHORT).show();


                adpter = new RecycleViewAdapter(listUser, listContent, listImage, getActivity(), listComment);
                mMyRec.setAdapter(adpter);

                linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                mMyRec.setLayoutManager(linearLayoutManager);


            }
        });




        return view;
    }

    private void initView(View view) {
        mMyRec = (RecyclerView) view.findViewById(R.id.myRec);
    }



    private void initData() {

            mMyRec.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    if (lastVisibleItemPosition==listUser.size()-1){
                        page++;
                        OkHttpManager.getInstance().asyncJsonStringByURL(path, new OkHttpManager.Func1() {
                            @Override
                            public void onResponse(String result) {

                                Gson gson = new Gson();
                                mebean myBean = gson.fromJson(result, mebean.class);

                                for (int i = 0; i < myBean.fuck.size(); i++) {
                                    listUser.add(myBean.fuck.get(i).User);
                                    listContent.add(myBean.fuck.get(i).Moment.content);
                                    listComment = myBean.fuck.get(i).Commentfuck;
                                    ;
                                    listImage.add(myBean.fuck.get(i).Moment.pictureList.get(i));
                                }



                                adpter.notifyDataSetChanged();

                            }
                        });

                    }
                }
            });

        }
}
