package com.eceakilli.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eceakilli.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
        //ViewBinding tanımlaması
        private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ViewBindingTanımlaması
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        //binding.contryText.setText("Test"); şeklinde direk işlem yapabiliyorsun.
        Intent intent=getIntent();
        LandMark selectedLAndmark=(LandMark) intent.getSerializableExtra("landmark"); //seçilen ögeyi yansıt

        //Singleton singleton=Singleton.getInstance();
        //LandMark selectedlandmark=singleton.getSentLandmark();

        binding.nameText.setText(selectedLAndmark.name);
        binding.contryText.setText(selectedLAndmark.country);
        binding.imageView.setImageResource(selectedLAndmark.image);

    }
}