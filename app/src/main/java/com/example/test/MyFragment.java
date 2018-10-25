package com.example.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author zcm
 * @create 2018/10/25
 * @Describe
 */
public class MyFragment extends Fragment{

    private TextView textView;
    String show_text = "";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show_text = getArguments().getString("show_text");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        textView = view.findViewById(R.id.text);
        textView.setText(show_text);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
