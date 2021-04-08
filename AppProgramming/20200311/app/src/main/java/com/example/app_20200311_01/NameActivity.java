package com.example.app_20200311_01;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NameActivity extends Fragment {
    public static NameActivity newInstance(String name) {
        NameActivity f = new NameActivity();

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        f.setArguments(bundle);

        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_name, container, false);

        return layout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setView(view);
    }

    private void setView(View view) {
        String name = getArguments().getString("name");

        TextView nameText = view.findViewById(R.id.tv1);
        nameText.setText(name);
    }
}