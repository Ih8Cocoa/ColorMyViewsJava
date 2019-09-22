package com.meow.colormyviewsjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.meow.colormyviewsjava.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    // setup layout binding
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Set listeners for boxes
        setListeners();
    }

    private void setListeners() {
        final List<View> clickableViews = Arrays.asList(
                binding.boxOne, binding.boxTwo, binding.boxThree,
                binding.boxFour, binding.boxFive, binding.constraintLayout,
                binding.redButton, binding.yellowButton, binding.greenButton
        );

        for (View view : clickableViews) {
            view.setOnClickListener(this::makeColored);
        }
    }

    // change color of the view
    private void makeColored(View view) {
        final int viewId = view.getId();
        // Add a flag on whether to call setBackgroundColor()
        // or setBackgroundResources() at the end
        // select the color depending on the view ID
        switch (viewId) {
            case R.id.box_one:
                view.setBackgroundColor(Color.DKGRAY);
                break;
            case R.id.box_two:
                view.setBackgroundColor(Color.GRAY);
                break;
            case R.id.box_three:
            case R.id.box_five:
                view.setBackgroundResource(android.R.color.holo_green_light);
                break;
            case R.id.box_four:
                view.setBackgroundResource(android.R.color.holo_green_dark);
                break;
            case R.id.red_button:
                binding.boxThree.setBackgroundResource(R.color.my_red);
                break;
            case R.id.yellow_button:
                binding.boxFour.setBackgroundResource(R.color.my_yellow);
                break;
            case R.id.green_button:
                binding.boxFive.setBackgroundResource(R.color.my_green);
                break;
            default:
                view.setBackgroundColor(Color.LTGRAY);
                break;
        }
    }
}
