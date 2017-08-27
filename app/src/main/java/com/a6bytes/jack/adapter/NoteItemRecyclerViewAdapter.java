package com.a6bytes.jack.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a6bytes.jack.R;
import com.a6bytes.jack.ui.main.fragment.NoteItemFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link NoteListItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class NoteItemRecyclerViewAdapter extends RecyclerView.Adapter<NoteItemRecyclerViewAdapter.ViewHolder> {

    private final List<NoteListItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public NoteItemRecyclerViewAdapter(List<NoteListItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_noteitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mSummaryView.setText(mValues.get(position).summary);
        holder.mContentView.setText(mValues.get(position).title);

        holder.mThumbnail.setImageDrawable(holder.mItem.thumbnail);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mSummaryView;
        public final TextView mContentView;
        public NoteListItem mItem;
        public final ImageView mThumbnail;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSummaryView = (TextView) view.findViewById(R.id.summary);
            mContentView = (TextView) view.findViewById(R.id.content);
            mThumbnail = (ImageView) view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    public static class NoteListItem {
        public int id;
        public String title;
        public String summary;
        public int year, month, day;
        public Drawable thumbnail;

        public NoteListItem(int id, String title, String summary, int[] date, Drawable thumbnail) {
            this.id = id;
            this.title = title;
            this.summary = summary;
            this.year   = date[0];
            this.month  = date[1];
            this.day    = date[2];
            this.thumbnail = thumbnail;
        }
    }
}
