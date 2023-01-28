package com.example.recipefinder.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefinder.R;
import com.example.recipefinder.acticities.FoodAdapter;
import com.example.recipefinder.acticities.HomePage;
import com.example.recipefinder.entity.FoodBody;
import com.example.recipefinder.ui.gallery.CheckOutPage;

import java.util.ArrayList;
import java.util.List;

public class MainHomeFragment extends Fragment implements View.OnClickListener{
    private RecyclerView foodList;
    private ImageButton fruitButton;
    private ImageButton meatButton;
    private ImageButton dairyButton;
    private ImageButton vegeButton;
    private ImageButton fishButton;
    private Button checkOut;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_page, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        foodList=view.findViewById(R.id.food_list);
        fruitButton=view.findViewById(R.id.fruitButton);
        fruitButton.setOnClickListener(this);

        meatButton=view.findViewById(R.id.meatButton);
        meatButton.setOnClickListener(this);

        dairyButton=view.findViewById(R.id.dairyButton);
        vegeButton=view.findViewById(R.id.vegeButton);
        fishButton=view.findViewById(R.id.fishButton);

        checkOut=view.findViewById(R.id.checkOutButton);
        checkOut.setOnClickListener(this);

        dairyButton.setOnClickListener(this);
        vegeButton.setOnClickListener(this);
        fishButton.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.dairyButton){
            initDairy();

        }else if(view.getId()==R.id.vegeButton){
            initVege();

        }else if(view.getId()==R.id.fishButton){
            initFish();

        }else if(view.getId()==R.id.fruitButton){
            initFruit();

        }else if(view.getId()==R.id.meatButton){
            initData();

        }else if(view.getId()==R.id.checkOutButton){
            Intent intent=new Intent(getActivity(), CheckOutPage.class);
            startActivity(intent);
        }

    }

    private void initFruit(){

        List<FoodBody> dataList=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Apple");
        one.setResId(R.drawable.apple_iv);
        one.setChoose(false);

        FoodBody two =new FoodBody();
        two.setName("Mango");
        two.setResId(R.drawable.mango_iv);
        two.setChoose(false);

        FoodBody three =new FoodBody();
        three.setName("Oranges");
        three.setResId(R.drawable.orange_iv);
        three.setChoose(false);

        FoodBody four =new FoodBody();
        four.setName("Banana");
        four.setResId(R.drawable.banana_iv);
        four.setChoose(false);

        dataList.add(one);
        dataList.add(two);
        dataList.add(three);
        dataList.add(four);

        FoodAdapter foodAdapter=new FoodAdapter(dataList, getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initData(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Beef");
        one.setResId(R.drawable.beef_iv);
        one.setChoose(false);

        FoodBody two =new FoodBody();
        two.setName("Shrimp");
        two.setResId(R.drawable.shrimp_iv);

        FoodBody three =new FoodBody();
        three.setName("Pork");
        three.setResId(R.drawable.pork_iv);
        three.setChoose(false);

        dataListMeat.add(one);
        dataListMeat.add(two);
        dataListMeat.add(three);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initDairy(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Milk");
        one.setResId(R.drawable.milk_iv);
        one.setChoose(false);

        dataListMeat.add(one);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initFish(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Fish");
        one.setResId(R.drawable.fish_iv);
        one.setChoose(false);

        dataListMeat.add(one);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }

    private void initVege(){
        List<FoodBody> dataListMeat=new ArrayList<>();
        FoodBody one =new FoodBody();
        one.setName("Tomato");
        one.setResId(R.drawable.tomato_iv);
        one.setChoose(false);

        FoodBody two =new FoodBody();
        two.setName("Potato");
        two.setResId(R.drawable.potato_iv);
        two.setChoose(false);

        FoodBody three =new FoodBody();
        three.setName("Onion");
        three.setResId(R.drawable.onion_iv);
        three.setChoose(false);

        dataListMeat.add(one);
        dataListMeat.add(two);
        dataListMeat.add(three);

        FoodAdapter foodAdapter=new FoodAdapter(dataListMeat,getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        foodList.setAdapter(foodAdapter);
        foodList.setLayoutManager(gridLayoutManager);

    }
}
