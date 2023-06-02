package com.example.databinding_tuan12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databinding_tuan12.databinding.NhanVienItemViewBinding;
import com.example.databinding_tuan12.modelview.NhanVienItemModelView;

import java.util.ArrayList;
import java.util.Optional;

public class NhanVienAdapter extends RecyclerView.Adapter<NhanVienAdapter.ViewHolder> {

    ArrayList<NhanVien> items;

    public NhanVienAdapter(ArrayList<NhanVien> items) {
        this.items = items;
    }

    public void insertNV(NhanVien nv) {
        Optional<NhanVien> exists = items.stream()
                .filter(x -> x.getMaNV() == nv.getMaNV())
                .findFirst();
        if(exists.isPresent()) {
            exists.get().setTenNV(nv.getTenNV());
            exists.get().setGioiTinh(nv.getGioiTinh());
        }
        else {
            items.add(nv);
        }
    }
    public void remove(NhanVien nhanVien) {
        items.remove(nhanVien);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NhanVienItemViewBinding binding = NhanVienItemViewBinding.inflate(
            LayoutInflater.from(parent.getContext()),
            parent,
            false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NhanVienItemModelView nhanVienItemModelView = new NhanVienItemModelView(items.get(position));
        holder.binding.setM(nhanVienItemModelView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        NhanVienItemViewBinding binding;
        public ViewHolder(@NonNull NhanVienItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public NhanVienItemViewBinding getBinding() {
            return this.binding;
        }
    }
}
