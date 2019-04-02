package com.example.lesson;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.core.BaseViewHolder;
import com.example.lesson.entity.Lesson;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {
    private List<Lesson> list = new ArrayList<>();

    void updateAndNotify(List<Lesson> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return LessonViewHolder.onCreate(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }


    /**
     * 静态内部类
     */
    public static class LessonViewHolder extends BaseViewHolder {

        LessonViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @NonNull
        private static LessonViewHolder onCreate(ViewGroup parent) {
            return new LessonViewHolder(LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.item_lesson, parent, false));
        }

        void onBind(Lesson lesson) {
            String date = lesson.getDate();
            if (date == null) {
                date = "日期待定";
            }
            setText(R.id.tv_date, date);

            setText(R.id.tv_content, lesson.getContent());

            final Lesson.State state = lesson.getState();
            if (state != null) {
                setText(R.id.tv_state, state.stateName());
                int colorRes = R.color.playback;
                switch (state) {
                    case PLAYBACK: {
                        // 即使在 {} 中也是需要 break 的。
                        colorRes = R.color.playback;
                        break;
                    }
                    case LIVE:
                        colorRes = R.color.live;
                        break;
                    case WAIT:
                        colorRes = R.color.wait;
                        break;
                }
                final int backgroundColor = itemView.getContext().getColor(colorRes);
                getView(R.id.tv_state).setBackgroundColor(backgroundColor);
            }
        }
    }
}
