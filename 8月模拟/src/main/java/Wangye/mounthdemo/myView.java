package Wangye.mounthdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * date 2017/9/20
 * functinn:
 */

public class myView extends LinearLayout{

    private TextView quanzi;
    private ImageView tupian;
    private TextView all;

    public myView(Context context) {
        this(context,null);
    }

    public myView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public myView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.myview, this, true);
        quanzi = (TextView) view.findViewById(R.id.quanzi);
        tupian = (ImageView) view.findViewById(R.id.tupian);
        all = (TextView) view.findViewById(R.id.all);
    }


}
