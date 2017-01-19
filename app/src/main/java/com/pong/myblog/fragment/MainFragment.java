package com.pong.myblog.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pong.myblog.R;
import com.pong.myblog.adapter.MainBlogAdapter;
import com.pong.myblog.contract.MainContract;
import com.pong.myblog.listener.OnMainFragmentListener;
import com.pong.myblog.model.BlogModel;
import com.pong.myblog.presenter.MainPresenter;

import java.util.List;

/**
 * Created by USER on 15/1/2560.
 */

public class MainFragment extends Fragment implements MainContract.MainView {
    private MainPresenter presenter;
    private MainBlogAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoBlogEditPage(-1);
            }
        });

        ListView listView = (ListView) view.findViewById(R.id.listview);
        adapter = new MainBlogAdapter(getActivity(),null);
        listView.setAdapter(adapter);

        presenter = new MainPresenter(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadAllBlog(getActivity());
    }

    @Override
    public void updateBlogList(List<BlogModel> list) {
        adapter.updateBlogList(list);
    }

    @Override
    public void gotoBlogEditPage(int blogId) {
        if(blogId > 0){
//            ((OnMainFragmentListener) getActivity()).onGoToExistBlog();
        }else{
            ((OnMainFragmentListener) getActivity()).onGoToCreateNewBlog();
        }
    }

    @Override
    public void gotoBlogPreviewPage(int blogId) {

    }
}
