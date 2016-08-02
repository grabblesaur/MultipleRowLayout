package recyclerview.sriyank.com.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import recyclerview.sriyank.com.recyclerview.R;
import recyclerview.sriyank.com.recyclerview.model.Landscape;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.LandscapeViewHolder> {
    public static final int PRIME = 0;
    public static final int NON_PRIME = 1;

    private List<Landscape> mLandscapeList;
    private int mLayoutResource;

    public RecyclerAdapter(ArrayList<Landscape> data) {
        mLandscapeList = data;
    }

    @Override
    public LandscapeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType) {
            case PRIME:
                view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_prime, parent, false);
                return new PrimeLandscapeViewHolder(view);
            case NON_PRIME:
                view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_not_prime, parent, false);
                return new NonPrimeLandscapeViewHolder(view);
            default:
                view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.list_item_not_prime, parent, false);
                return new NonPrimeLandscapeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(LandscapeViewHolder holder, int position) {
        Landscape currentLandscape = mLandscapeList.get(position);
        switch (holder.getItemViewType()) {
            case PRIME:
                PrimeLandscapeViewHolder primeHolder = (PrimeLandscapeViewHolder) holder;
                primeHolder.setData(currentLandscape);
                break;
            case NON_PRIME:
                NonPrimeLandscapeViewHolder nonPrimeHolder = (NonPrimeLandscapeViewHolder) holder;
                nonPrimeHolder.setData(currentLandscape);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Landscape landscape = mLandscapeList.get(position);
        return landscape.isPrime() ? PRIME : NON_PRIME;
    }

    @Override
    public int getItemCount() {
        return mLandscapeList.size();
    }

    class LandscapeViewHolder extends RecyclerView.ViewHolder {
        public LandscapeViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class PrimeLandscapeViewHolder extends LandscapeViewHolder {
        @BindView(R.id.img_row)
        ImageView image;
        @BindView(R.id.tvTitle)
        TextView title;
        @BindView(R.id.tvDescription)
        TextView desc;
        @BindView(R.id.img_row_prime)
        ImageView imagePrime;

        public PrimeLandscapeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Landscape currentLandscape) {
            image.setImageResource(currentLandscape.getImageID());
            title.setText(currentLandscape.getTitle());
            desc.setText(currentLandscape.getDescription());
            imagePrime.setImageResource(R.drawable.prime);
        }
    }

    public class NonPrimeLandscapeViewHolder extends LandscapeViewHolder {
        @BindView(R.id.img_row)
        ImageView image;
        @BindView(R.id.tvTitle)
        TextView title;
        @BindView(R.id.tvDescription)
        TextView desc;
        @BindView(R.id.img_row_not_prime)
        ImageView imagePrime;

        public NonPrimeLandscapeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(Landscape currentLandscape) {
            image.setImageResource(currentLandscape.getImageID());
            title.setText(currentLandscape.getTitle());
            desc.setText(currentLandscape.getDescription());
            imagePrime.setImageResource(R.drawable.not_prime);
        }
    }
}
