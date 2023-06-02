package com.example.databinding_tuan12.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databinding_tuan12.R;
import com.example.databinding_tuan12.databinding.FragmentQLNVBinding;
import com.example.databinding_tuan12.modelview.FormNhapModelView;

public class QLNVFragment extends Fragment {
    FragmentQLNVBinding binding;
    FormNhapModelView m = new FormNhapModelView();
    public QLNVFragment() {
        // Required empty public constructor
    }

    public static QLNVFragment newInstance() {
        QLNVFragment fragment = new QLNVFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQLNVBinding.inflate(inflater, container, false);
        binding.setM(m);
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("NV", m.nv.get());
                getActivity().getSupportFragmentManager().setFragmentResult("data", bundle);
                m.resetNV();
            }
        });
        return binding.getRoot();
    }
}