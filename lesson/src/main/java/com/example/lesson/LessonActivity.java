package com.example.lesson;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.core.BaseView;
import com.example.lesson.entity.Lesson;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class LessonActivity extends AppCompatActivity implements BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {
    private LessonPresenter lessonPresenter = new LessonPresenter(this);

    @Override
    public LessonPresenter getPresenter() {
        return lessonPresenter;
    }

    private LessonAdapter lessonAdapter = new LessonAdapter();

    private SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_lesson);
        toolbar.setOnMenuItemClickListener(this);

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(lessonAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        refreshLayout = findViewById(R.id.swipe_refresh_layout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().fetchData();
            }
        });
        refreshLayout.setRefreshing(true);

        getPresenter().fetchData();
    }

    public void showResult(List<Lesson> lessons) {
        lessonAdapter.updateAndNotify(lessons);
        refreshLayout.setRefreshing(false);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        getPresenter().showPlayback();
        return false;
    }
}
