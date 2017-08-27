package com.a6bytes.jack.ui.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a6bytes.jack.R;
import com.a6bytes.jack.adapter.NoteItemRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class NoteItemFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NoteItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NoteItemFragment newInstance(int columnCount) {
        NoteItemFragment fragment = new NoteItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noteitem_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            List<NoteItemRecyclerViewAdapter.NoteListItem> ITEMS = new ArrayList<>();
            int[] date = {2000, 8, 12};
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));

            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));
            ITEMS.add(new NoteItemRecyclerViewAdapter.NoteListItem(0,"test", "summary", date, getResources().getDrawable(R.drawable.side_nav_bar_bg)));

            recyclerView.setAdapter(new NoteItemRecyclerViewAdapter(ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
        // TODO: Update argument type and name
        void onListFragmentInteraction(NoteItemRecyclerViewAdapter.NoteListItem item);
    }

    public void onListClick(NoteItemRecyclerViewAdapter.NoteListItem item){
        return;
    }
}
