package com.example.recipefinder.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefinder.FavAdapter;
import com.example.recipefinder.R;
import com.example.recipefinder.entity.RecipeBody;

import java.util.ArrayList;
import java.util.List;

public class PlanFragment extends Fragment implements View.OnClickListener{

    private RecyclerView recyclerView;
    private RelativeLayout breakfast,lunch ,dinner;
    private FavAdapter favAdapter;
    int index=1;

    private TextView calLeft, calCenter, calRight;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plan, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recipe_list);
        breakfast=view.findViewById(R.id.breakfast_area);
        lunch=view.findViewById(R.id.lunch_area);
        dinner=view.findViewById(R.id.dinner_area);

        breakfast.setOnClickListener(this);
        lunch.setOnClickListener(this);
        dinner.setOnClickListener(this);

        calCenter=view.findViewById(R.id.cal_center);
        calLeft=view.findViewById(R.id.cal_left);
        calRight=view.findViewById(R.id.cal_right);
    }

    @Override
    public void onResume() {
        super.onResume();


        favAdapter=new FavAdapter(new ArrayList<>(),getActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setAdapter(favAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        if(index==0){
            initBreakfast();
        }else if(index==1){
            initLunch();
        }else if(index==2){
            initDinner();
        }

        calRight.setText(getActivity().getString(R.string.cal_num,1279));
        calLeft.setText(getActivity().getString(R.string.cal_num,1269));
        calCenter.setText(getActivity().getString(R.string.cal_num,10));

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.breakfast_area){
            breakfast.setBackground(getActivity().getDrawable(R.drawable.plan_orange_bg));
            lunch.setBackground(getActivity().getDrawable(R.drawable.plan_white_bg));
            dinner.setBackground(getActivity().getDrawable(R.drawable.plan_white_bg));
            initBreakfast();
            index=0;

        }else if(view.getId()==R.id.lunch_area){
            lunch.setBackground(getActivity().getDrawable(R.drawable.plan_orange_bg));
            breakfast.setBackground(getActivity().getDrawable(R.drawable.plan_white_bg));
            dinner.setBackground(getActivity().getDrawable(R.drawable.plan_white_bg));
            initLunch();
            index=1;

        }else if(view.getId()==R.id.dinner_area){
            dinner.setBackground(getActivity().getDrawable(R.drawable.plan_orange_bg));
            lunch.setBackground(getActivity().getDrawable(R.drawable.plan_white_bg));
            breakfast.setBackground(getActivity().getDrawable(R.drawable.plan_white_bg));
            initDinner();
            index=2;

        }

    }

    private void initBreakfast(){

        RecipeBody one=new RecipeBody();
        one.setName("Onion tomato soup");
        one.setResId(R.drawable.onion_tomato_soup);
        one.setIngredient("Onion tomato chicken beef");
        one.setMake("In a large pot, gently sauté the onions in the butter until they caramelize, about 15 minutes. Season with salt and pepper. Deglaze with the wine. Add the broth and tomatoes. Bring to a boil and simmer for about 10 minutes. Season with salt and pepper.");
        one.setCalories(249);


        List<RecipeBody> recipeBodyList=new ArrayList<>();
        recipeBodyList.add(one);
        favAdapter.setNewData(recipeBodyList);
        favAdapter.notifyDataSetChanged();

//        FavAdapter favAdapter=new FavAdapter(recipeBodyList,getActivity());
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
//        recyclerView.setAdapter(favAdapter);
//        recyclerView.setLayoutManager(gridLayoutManager);
    }



    private void initLunch(){



        RecipeBody two=new RecipeBody();
        two.setName("Bone-in Pork Chops");
        two.setResId(R.drawable.bone_pork);
        two.setIngredient("pork");
        two.setMake("Season the pork chops on both sides with salt and pepper. In a large, cast-iron skillet, heat the oil, three turns of the pan, over medium-high. When the oil ripples and smokes, add the chops and cook until browned, 2 minutes per side. Using tongs, lift the chops and brown them on the edges; transfer to a plate");
        two.setCalories(390);

        RecipeBody three=new RecipeBody();
        three.setName("Shrimp with Mustard Sauce");
        three.setResId(R.drawable.recipe_shrimp);
        three.setIngredient("shrimp");
        three.setMake("In a bowl, whisk together the cornstarch and water. Stir in the mustard and set aside.");
        three.setCalories(290);



        List<RecipeBody> recipeBodyList=new ArrayList<>();
        recipeBodyList.add(two);
        recipeBodyList.add(three);

        favAdapter.setNewData(recipeBodyList);
        favAdapter.notifyDataSetChanged();


    }



    private void initDinner(){



        RecipeBody four=new RecipeBody();
        four.setName("Indian Style Fish");
        four.setResId(R.drawable.recipe_shrimp);
        four.setIngredient("fish");
        four.setMake("In a saucepan, soften the onion over medium heat in 45 ml (3 tablespoons) of oil, until translucent. Season with salt. Add the garlic, tomato paste, and spices and cook for about 2 minutes, stirring constantly.");
        four.setCalories(350);

        List<RecipeBody> recipeBodyList=new ArrayList<>();
        recipeBodyList.add(four);


        favAdapter.setNewData(recipeBodyList);
        favAdapter.notifyDataSetChanged();


    }
}
