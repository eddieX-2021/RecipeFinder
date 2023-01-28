package com.example.recipefinder.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefinder.FavAdapter;
import com.example.recipefinder.R;
import com.example.recipefinder.entity.FoodBody;
import com.example.recipefinder.entity.RecipeBody;
import com.example.recipefinder.ui.gallery.CheckOutAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class FavFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recipe_list);

    }

    private void initData(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("collect", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        List<RecipeBody> lists = new ArrayList<>();
        String strJson = sharedPreferences.getString("collectDetail", null);
        if (strJson != null) {
            Gson gson = new Gson();
            lists = gson.fromJson(strJson, new TypeToken<List<RecipeBody>>() {
            }.getType());


            FavAdapter favAdapter=new FavAdapter(lists,getActivity());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
            recyclerView.setAdapter(favAdapter);
            recyclerView.setLayoutManager(gridLayoutManager);


        }
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
    }
}
