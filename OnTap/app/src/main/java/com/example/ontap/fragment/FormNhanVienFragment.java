package com.example.ontap.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ontap.NhanVien;
import com.example.ontap.R;
import com.example.ontap.databinding.FragmentFormNhanVienBinding;
import com.example.ontap.viewmodel.FormNhapNhanVienViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormNhanVienFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormNhanVienFragment extends Fragment {

    FragmentFormNhanVienBinding binding;

    FormNhapNhanVienViewModel vm = new FormNhapNhanVienViewModel();


    public FormNhanVienFragment() {
        // Required empty public constructor
    }

    public static FormNhanVienFragment newInstance() {
        FormNhanVienFragment fragment = new FormNhanVienFragment();
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
        // Inflate the layout for this fragment
        binding = FragmentFormNhanVienBinding.inflate(inflater, container, false);
        binding.setM(vm);

        binding.btnNhapNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nhanVien = vm.nhanVien.get();
                Bundle bundle = new Bundle();
                bundle.putSerializable("DATA", nhanVien);
                getActivity().getSupportFragmentManager().setFragmentResult(
                        "SUBMIT",
                        bundle
                );
                vm.resetNhanVien();
            }
        });

        return binding.getRoot();
    }

}