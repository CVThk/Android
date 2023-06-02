package com.example.ontap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ontap.databinding.LayoutNhanVienItemBinding;
import com.example.ontap.viewmodel.NhanVienItemViewModel;

import java.util.ArrayList;
import java.util.Optional;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder> {

    ArrayList<NhanVien> items = new ArrayList<>();

    public void insert(NhanVien nhanVien) {
        Optional<NhanVien> exist = items.stream()
                .filter(nv -> nv.getMa().equals(nhanVien.getMa()))
                .findFirst();
        if (exist.isPresent()) {
            exist.get().setGender(nhanVien.getGender());
            exist.get().setTen(nhanVien.getTen());
        } else {
            items.add(nhanVien);
        }
        notifyDataSetChanged();
    }

    public void remove(NhanVien nhanVien) {
        items.remove(nhanVien);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutNhanVienItemBinding binding = LayoutNhanVienItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NhanVienItemViewModel vm = new NhanVienItemViewModel(
                items.get(position)
        );
        holder.binding.setM(vm);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LayoutNhanVienItemBinding binding;

        public ViewHolder(@NonNull LayoutNhanVienItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public LayoutNhanVienItemBinding getBinding() {
            return binding;
        }
    }
}
