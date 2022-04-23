package com.example.uno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayPage(View view) {
        System.out.println("CLICKED");
        ButtonsFragment fragment = new ButtonsFragment();
        fragment.setContainerActivity(this);
        Bundle args = new Bundle();

        if (view.getId() == R.id.help_button) {
            args.putInt("layout_id", R.layout.info_pages_layout);
            args.putString("page_name", "help");
        } else if (view.getId() == R.id.settings_button) {
            args.putInt("layout_id", R.layout.settings_page_layout);
        } else if (view.getId() == R.id.instructions_button) {
            args.putInt("layout_id", R.layout.info_pages_layout);
            args.putString("page_name", "instructions");
        } else if (view.getId() == R.id.new_game_button) {
            //args.putInt("layout_name", R.id.);
        }

        fragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // should i be replacing the last fragment?
        transaction.replace(R.id.main_activity, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}