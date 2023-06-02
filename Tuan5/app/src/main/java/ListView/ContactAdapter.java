package ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    ArrayList<Contact> items;
    Context context;

    public ContactAdapter(ArrayList<Contact> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater li = LayoutInflater.from(context);
        View layout = li.inflate(R.layout.contact_item_layout, null);

        TextView name = layout.findViewById(R.id.contactItem_name);
        Contact contact =items.get(i);
        name.setText(contact.getName());

        TextView phone = layout.findViewById(R.id.contactItem_phone);
        phone.setText(contact.getPhone());

        return layout;
    }
}
