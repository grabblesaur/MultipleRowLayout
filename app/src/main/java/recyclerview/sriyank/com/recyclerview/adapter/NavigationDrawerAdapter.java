package recyclerview.sriyank.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import recyclerview.sriyank.com.recyclerview.R;
import recyclerview.sriyank.com.recyclerview.model.NavigationDrawerItem;

public class NavigationDrawerAdapter
        extends RecyclerView.Adapter<NavigationDrawerAdapter.NavigationDrawerViewHolder> {

    private List<NavigationDrawerItem> mList = Collections.emptyList();
    private Context mContext;

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> data) {
        mList = data;
        mContext = context;
    }

    @Override
    public NavigationDrawerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_navigation, parent, false);
        return new NavigationDrawerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NavigationDrawerViewHolder holder, int position) {
        NavigationDrawerItem currentItem = mList.get(position);
        holder.setUpData(currentItem);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class NavigationDrawerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nav_item_icon)
        ImageView navItemIcon;
        @BindView(R.id.nav_item_text)
        TextView navItemText;

        public NavigationDrawerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setUpData(NavigationDrawerItem currentItem) {
            navItemIcon.setImageResource(currentItem.getImageId());
            navItemText.setText(currentItem.getTitle());
        }

        @OnClick(R.id.item_container) void onItemClick() {
            Toast.makeText(mContext, navItemText.getText().toString(), Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
