package com.fkm.recyclerviewmultitype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fkm.recyclerviewmultitype.adapter.FilmReviewAdapter;
import com.fkm.recyclerviewmultitype.model.FilmReviewInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FilmReviewAdapter adapter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.mRecyclerView);
        getData();
    }

    /**
     * 模拟请求数据
     */
    private void getData() {

        final List<FilmReviewInfo> mList = new ArrayList<>();

        /** 模拟数据开始 */

        FilmReviewInfo filmReviewInfo1 = new FilmReviewInfo();
        filmReviewInfo1.setTitle("《拆弹专家2》呈现了一场多变而又扎实的跳脱与反观");
        filmReviewInfo1.setCoverImg("https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2621379901.webp");
        filmReviewInfo1.setCoverImgType(2); // 视图显示类型
        filmReviewInfo1.setAuthor("徐若风");
        filmReviewInfo1.setPublishedDate("2021-1-15");
        mList.add(filmReviewInfo1);

        FilmReviewInfo filmReviewInfo2 = new FilmReviewInfo();
        filmReviewInfo2.setTitle("在我的人生里，有过一场重大的幻灭。");
        filmReviewInfo2.setCoverImg("https://img3.doubanio.com/view/thing_review/l/public/5427631.jpg");
        filmReviewInfo2.setCoverImgType(1); // 视图显示类型
        filmReviewInfo2.setAuthor("林探惜");
        filmReviewInfo2.setPublishedDate("2021-1-15");
        mList.add(filmReviewInfo2);

        FilmReviewInfo filmReviewInfo3 = new FilmReviewInfo();
        filmReviewInfo3.setTitle("看似“套路”独立电影，胜在举重若轻，游牧者永远在路上");
        filmReviewInfo3.setCoverImg("https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2628328069.webp");
        filmReviewInfo3.setCoverImgType(2); // 视图显示类型
        filmReviewInfo3.setAuthor("陀螺电影");
        filmReviewInfo3.setPublishedDate("2021-1-15");
        mList.add(filmReviewInfo3);

        FilmReviewInfo filmReviewInfo4 = new FilmReviewInfo();
        filmReviewInfo4.setTitle("解压神片，看完想去搓个澡");
        filmReviewInfo4.setCoverImg("https://img2.doubanio.com/view/photo/s_ratio_poster/public/p2627788612.webp");
        filmReviewInfo4.setCoverImgType(2); // 视图显示类型
        filmReviewInfo4.setAuthor("吉撸万岁");
        filmReviewInfo4.setPublishedDate("2021-1-15");
        mList.add(filmReviewInfo4);

        FilmReviewInfo filmReviewInfo5 = new FilmReviewInfo();
        filmReviewInfo5.setTitle("《Soul》的剧情分析与讨论，篇幅很长，感谢耐心阅读。");
        filmReviewInfo5.setCoverImg("https://img3.doubanio.com/view/thing_review/l/public/5506580.webp");
        filmReviewInfo5.setCoverImgType(1); // 视图显示类型
        filmReviewInfo5.setAuthor("弗吉尼亚的灵魂");
        filmReviewInfo5.setPublishedDate("2021-1-15");
        mList.add(filmReviewInfo5);

        /** 模拟数据结束 */


        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        adapter = new FilmReviewAdapter(this, mList);
        mRecyclerView.setAdapter(adapter);

        adapter.setItemClickListener(new FilmReviewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String title = mList.get(position).getTitle();
                Toast.makeText(MainActivity.this, "" + title, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

}