package com.alanueyn.projects.itunesalbumviewer.view.listener;

import android.view.View;

/**
 * The base interface for custom RecyclerView touch listener
 */

public interface ClickListener {
    void onClick(View view, int posititon);
    void onLongClick(View view, int position);
}