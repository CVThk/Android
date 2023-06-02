package RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

import ListView.Contact;

public class RecyleAdapter extends RecyclerView.Adapter<RecyleAdapter.ViewHolder> {

    Context context;
    ArrayList<Contact> items;

    public RecyleAdapter(Context context, ArrayList<Contact> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View layout = li.inflate(R.layout.contact_item_layout, parent,false);
        ViewHolder holder = new ViewHolder(layout);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = items.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvPhone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.contactItem_name);
            tvPhone = itemView.findViewById(R.id.contactItem_phone);
        }
    }
}
