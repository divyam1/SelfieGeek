package com.example.selfiegeek.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.selfiegeek.Adapter.ImagesGridAdapter;
import com.example.selfiegeek.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import static com.example.selfiegeek.Activity.GridActivity.imageList;


public class ImagesGridFragment extends Fragment {

   public ImagesGridFragment() {
        // Required empty public constructor
    }
    private static final String TAG = "ImageGridFragment";

    RecyclerView recyclerView;
    ImagesGridAdapter adapter;
    TextView textview1;
    ArrayList<URL> imageAl;

      @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_images_grid, container, false);
        imageAl = new ArrayList<>();
        recyclerView = (RecyclerView) v.findViewById(R.id.imagesRecyclerView);
        textview1 = (TextView) v.findViewById(R.id.tvempty);
          for (Iterator<String> it = imageList.iterator(); it.hasNext(); ) {
              String f = it.next();
              URL url = null;
              try {
                  url = new URL(f);
              } catch (MalformedURLException e) {
                  e.printStackTrace();
              }
              imageAl.add(url);
          }
        adapter = new ImagesGridAdapter(getContext(), imageAl, getActivity(), recyclerView);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return v;
    }

    @Override
    public void onStart() {
        super.onStart();


        if (imageList.isEmpty()) {
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
