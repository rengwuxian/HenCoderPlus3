package com.example.core.http;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface EntityCallback<T> {
    void onSuccess(@NonNull T entity);

    void onFailure(@Nullable String message);
}
