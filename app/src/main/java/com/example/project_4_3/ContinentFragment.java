package com.example.project_4_3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class ContinentFragment extends Fragment {
    private RecyclerView recyclerView;
    private ContinentAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_continent, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<String> continents = Arrays.asList("Africa", "Asia", "Europe", "North America", "Oceania", "South America");
        adapter = new ContinentAdapter(continents, this::onContinentSelected);
        recyclerView.setAdapter(adapter);

        return view;
    }
    private void onContinentSelected(String continent) {
        Log.d("ContinentFragment", "Continent selected: " + continent);
        CountryFragment countryFragment = CountryFragment.newInstance(continent);
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, countryFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}