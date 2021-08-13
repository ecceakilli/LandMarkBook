package com.eceakilli.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.eceakilli.landmarkbook.databinding.ActivityDetailsBinding;
import com.eceakilli.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> landMarkArrayList;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //------------------Binding--------------//
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        landMarkArrayList=new ArrayList<>();

        //DATA
        LandMark pisa=new LandMark("Pisa","Italy",R.drawable.pisa);
        LandMark eiffel=new LandMark("Eiyyfel","France",R.drawable.eyfel);
        LandMark colosseum=new LandMark("Coloseum","Italt",R.drawable.colloseum);

        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(colosseum);

        binding.recylerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapterRecylerView landmarkAdapterRecylerView=new LandmarkAdapterRecylerView(landMarkArrayList);
        binding.recylerView.setAdapter(landmarkAdapterRecylerView);

        /////mapping--kullanma nedenimiz arraylistimiz de ki isimlerin nasıl çıkmasını karar veriyoruz
  /*      *******************ListView********** (verimsiz) Adapter
        List<String> list = new ArrayList<>();
        for (LandMark landMark : landMarkArrayList) {
            String name = landMark.name;
            list.add(name);
        }
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                list);
        binding.listView.setAdapter(arrayAdapter);

        ////////listViewe tıklandıgında
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,landMarkArrayList.get(i).name,Toast.LENGTH_LONG).show();--listViewde hangi satıra tıklanıldıgının bilgisini verir.
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);//Diğer sayfaya geçiş için intent oluşturduk
                intent.putExtra("landmark",landMarkArrayList.get(i));//listviewde tıklanıldıgı alanın verileri aktarır.

                startActivity(intent);

            }
        });
*/
    }
}