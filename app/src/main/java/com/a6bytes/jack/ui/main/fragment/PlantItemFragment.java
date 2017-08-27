package com.a6bytes.jack.ui.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a6bytes.jack.R;
import com.a6bytes.jack.adapter.PlantItemRecyclerViewAdapter;
import com.a6bytes.jack.ui.plant.PlantActivity;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link PlantItemRecyclerViewAdapter.OnListFragmentInteractionListener}
 * interface.
 */
public class PlantItemFragment extends Fragment{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private PlantItemRecyclerViewAdapter.OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PlantItemFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PlantItemFragment newInstance(int columnCount) {
        PlantItemFragment fragment = new PlantItemFragment();
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

    PlantItemRecyclerViewAdapter adapter;
    List<PlantItemRecyclerViewAdapter.Item> mList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plantitem_list, container, false);

        adapter = new PlantItemRecyclerViewAdapter(mList, mListener);
        adapter.addItem(0, "오레가노 (전호균)", "상태 좋음", getResources().getDrawable(R.drawable.side_nav_bar_bg));
        adapter.addItem(1, "오레가노 (전호균)", "상태 좋음", getResources().getDrawable(R.drawable.side_nav_bar_bg));
        adapter.addItem(2, "오레가노 (전호균)", "상태 좋음", getResources().getDrawable(R.drawable.side_nav_bar_bg));
        adapter.addItem(3, "오레가노 (전호균)", "상태 좋음", getResources().getDrawable(R.drawable.side_nav_bar_bg));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(adapter);
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PlantItemRecyclerViewAdapter.OnListFragmentInteractionListener) {
            mListener = (PlantItemRecyclerViewAdapter.OnListFragmentInteractionListener) context;
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

    //MainActivity에서 연결해줌 >> 수정 필요할 듯 (onListFragmentInteraction
    public void onListClick(PlantItemRecyclerViewAdapter.Item item) {
        //테스트용
        Intent intent = new Intent(getActivity(), PlantActivity.class);
        //이후에 여기로 id를 주고 받도록 수정 필요
        startActivity(intent);
    }
}
