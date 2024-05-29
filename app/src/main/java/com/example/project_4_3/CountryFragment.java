package com.example.project_4_3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CountryFragment extends Fragment {
    private static final String ARG_CONTINENT = "continent";
    private RecyclerView recyclerView;
    private CountryAdapter adapter;

    public static CountryFragment newInstance(String continent) {
        CountryFragment fragment = new CountryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTINENT, continent);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_country, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        String continent = getArguments().getString(ARG_CONTINENT);
        List<String> countries = getCountriesForContinent(continent);
        adapter = new CountryAdapter(countries);
        recyclerView.setAdapter(adapter);

        return view;
    }
    private List<String> getCountriesForContinent(String continent) {
        switch (continent) {
            case "Africa":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Morocco");
            case "Asia":
                return Arrays.asList("China", "India", "Japan", "South Korea", "Indonesia");
            case "Europe":
                return Arrays.asList("Germany", "France", "United Kingdom", "Italy", "Spain");
            case "North America":
                return Arrays.asList("United States", "Canada", "Mexico", "Cuba", "Jamaica");
            case "Oceania":
                return Arrays.asList("Australia", "New Zealand", "Fiji", "Papua New Guinea", "Samoa");
            case "South America":
                return Arrays.asList("Brazil", "Argentina", "Colombia", "Chile", "Peru");
            default:
                return Collections.emptyList();
        }
    }

}