package com.example.selfiegeek.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.selfiegeek.Adapter.VideosGridAdapter;
import com.example.selfiegeek.R;

import java.util.ArrayList;
import java.util.Iterator;

import static com.example.selfiegeek.Activity.GridActivity.videoList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideosGridFragment//.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideosGridFragment//#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VideosGridFragment extends Fragment {

    public VideosGridFragment() {
        // Required empty public constructor
    }
    private static final String TAG = "VideosGridFragment";

    RecyclerView recyclerView;
    VideosGridAdapter adapter;
    TextView textview1;
    ArrayList<Uri> videoAl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_videos_grid, container, false);
        videoAl= new ArrayList<>();
        recyclerView = (RecyclerView) v.findViewById(R.id.videosRecyclerView);
        textview1 = (TextView) v.findViewById(R.id.tvempty);
        for (Iterator<String> it = videoList.iterator(); it.hasNext(); ) {
            String f = it.next();
            Uri video = Uri.parse(f);
            videoAl.add(video);
        }
        adapter = new VideosGridAdapter(getContext(), videoAl, getActivity(), recyclerView);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onStart() {
        super.onStart();


        if (videoAl.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            textview1.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            textview1.setVisibility(View.GONE);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


}
