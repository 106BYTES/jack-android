package com.a6bytes.jack.ui.main.fragment;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a6bytes.jack.R;

import java.util.ArrayList;
import java.util.List;

public class PlantItemRecyclerViewAdapter extends RecyclerView.Adapter<PlantItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> items = new ArrayList<Item>();
    private final OnListFragmentInteractionListener mListener;




    public PlantItemRecyclerViewAdapter(List<Item> items, OnListFragmentInteractionListener listener) {
        //this.items = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_plantitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = items.get(position);
        holder.mSummaryView.setText(items.get(position).summary);
        holder.mImageView.setImageDrawable(items.get(position).drawable);
        holder.mContentView.setText(items.get(position).name);

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

    public void addItem(Item item) {
        items.add(item);
    }
    public void addItem(int index, String name, String summary, Drawable drawable) {
        items.add(new Item(index, name, summary, drawable));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mContentView, mSummaryView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.imageView);
            mContentView = (TextView) view.findViewById(R.id.content);
            mSummaryView = (TextView) view.findViewById(R.id.summary);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    //==============================================================================================

    public class Item {

        public int index;
        public String name;
        public String summary;
        public Drawable drawable;

        public Item(int index, String name, String summary, Drawable drawable) {
            this.index = index;
            this.name = name;
            this.summary = summary;
            this.drawable = drawable;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(PlantItemRecyclerViewAdapter.Item item);
    }
}
