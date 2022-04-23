package com.example.uno;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 * @authors: Carolina Oliva-Martinez, Georgia West
 * @description: This program creates a Fragment for the Help, Settings, and Instructions pages.
 */

public class ButtonsFragment extends Fragment {

    public Activity containerActivity = null;
    public Integer layout_id = null;
    public String page = null;
    public MediaPlayer player;

    public ButtonsFragment() { }

    public void setContainerActivity(Activity containerActivity) {
        this.containerActivity = containerActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        layout_id = args.getInt("layout_id");
        if (layout_id == R.id.info_layout) {
            page = args.getString("page_name");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Is this allowed? (setting the layout to something other than the fragment layout
        View v = inflater.inflate(layout_id, container, false);

        if (page == "help") {
            TextView tv = v.findViewById(R.id.info_text);
            tv.setText(R.string.help_description);
        } else if (page == "instructions") {
            TextView tv = v.findViewById(R.id.info_text);
            tv.setText(R.string.instructions);
        }

        // TODO: replace button layout with correct layout

        return v;
    }
}