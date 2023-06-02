package com.example.databinding_tuan12.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.databinding_tuan12.NhanVien;
import com.example.databinding_tuan12.NhanVienAdapter;
import com.example.databinding_tuan12.R;
import com.example.databinding_tuan12.databinding.FragmentDSNVBinding;
import com.example.databinding_tuan12.modelview.NhanVienItemModelView;

import java.util.ArrayList;
import java.util.Optional;

public class DSNVFragment extends Fragment {

    FragmentDSNVBinding binding;
    ArrayList<NhanVien> nhanViens = new ArrayList<NhanVien>();
    NhanVienAdapter adapter = new NhanVienAdapter(nhanViens);
    public DSNVFragment() {
        // Required empty public constructor
    }

    public static DSNVFragment newInstance() {
        DSNVFragment fragment = new DSNVFragment();
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
        binding = FragmentDSNVBinding.inflate(
                inflater,
                container,
                false
        );
        nhanViens.add(new NhanVien("2", "2", 0));
        nhanViens.add(new NhanVien("1", "2", 1));
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(container.getContext()));
        getActivity().getSupportFragmentManager().setFragmentResultListener("data", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                NhanVien nv = (NhanVien) result.get("NV");
                Log.d("NV", nv.getTenNV());
                adapter.insertNV(nv);
                adapter.notifyDataSetChanged();
            }
        });

        binding.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = adapter.getItemCount();
                ArrayList<NhanVien> selected = new ArrayList<>();
                for(int i = 0; i < size; i++) {
                    NhanVienAdapter.ViewHolder viewHolder = (NhanVienAdapter.ViewHolder) binding.recyclerview.findViewHolderForLayoutPosition(i);
                    NhanVienItemModelView modelView = viewHolder.getBinding().getM();
                    if(modelView.isCheck()) {
                        selected.add(modelView.getNv());
                    }
                }
                for(NhanVien nv : selected) {
                    adapter.remove(nv);
                }
            }
        });

        return binding.getRoot();
    }
}