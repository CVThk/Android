package com.example.ontap.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ontap.NhanVien;
import com.example.ontap.NhanVienAdapter;
import com.example.ontap.R;
import com.example.ontap.databinding.FragmentListNhanVienBinding;
import com.example.ontap.viewmodel.NhanVienItemViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListNhanVienFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListNhanVienFragment extends Fragment {

    // Phải có được instance của FormNhanVienFragment

    FragmentListNhanVienBinding binding;
    NhanVienAdapter adapter = new NhanVienAdapter();

    public ListNhanVienFragment() {
        // Required empty public constructor
    }

    public static ListNhanVienFragment newInstance() {
        ListNhanVienFragment fragment = new ListNhanVienFragment();
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

        binding = FragmentListNhanVienBinding.inflate(inflater, container, false);

        getActivity().getSupportFragmentManager().setFragmentResultListener("SUBMIT", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                NhanVien nhanVien = (NhanVien) result.get("DATA");
                Log.e("Nhan data", nhanVien.getMa());
                Log.e("Nhan data", nhanVien.getTen());
                Log.e("Nhan data", String.valueOf(nhanVien.getGender()));
                adapter.insert(nhanVien);
            }
        });

        binding.recyclerListNhanVien.setAdapter(adapter);
        binding.recyclerListNhanVien.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.btnRemoveNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = adapter.getItemCount();
                ArrayList<NhanVien> selectedNhanVien = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    NhanVienAdapter.ViewHolder viewHolder = (NhanVienAdapter.ViewHolder) binding.recyclerListNhanVien.findViewHolderForAdapterPosition(i);
                    NhanVienItemViewModel vm = viewHolder.getBinding().getM();
                    if (vm.isChecked()) {
                        selectedNhanVien.add(vm.getNhanVien());
                    }
                }

                selectedNhanVien.forEach(nv -> adapter.remove(nv));
            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}