package Test.musicapp.topsongs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import Test.musicapp.R;
import Test.musicapp.api.TrendingSingle;

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolder> {

    private List<TrendingSingle> trendingSingles;

    TopSongsAdapter(List<TrendingSingle> trendingSingles) {
        this.trendingSingles = trendingSingles;
    }

    @Override
    public TopSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_top_songs, parent, false);

        return new TopSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopSongsViewHolder holder, int position) {
        TrendingSingle trendingSingle = this.trendingSingles.get(position);

        holder.tvPlace.setText(String.valueOf(trendingSingle.intChartPlace));
        holder.tvTrack.setText(trendingSingle.strTrack);
        holder.tvArtist.setText(trendingSingle.strArtist);
        holder.tvAlbum.setText(trendingSingle.strAlbum);
    }

    @Override
    public int getItemCount() {
        return this.trendingSingles == null ? 0 : this.trendingSingles.size();
    }

    public class TopSongsViewHolder extends RecyclerView.ViewHolder {

        TextView tvPlace;
        TextView tvTrack;
        TextView tvArtist;
        TextView tvAlbum;

        public TopSongsViewHolder(View itemView) {
            super(itemView);

            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvTrack = itemView.findViewById(R.id.tvTrack);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
        }
    }

}
