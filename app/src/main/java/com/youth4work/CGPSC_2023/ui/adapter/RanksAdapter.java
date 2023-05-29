package com.youth4work.CGPSC_2023.ui.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import com.youth4work.CGPSC_2023.R;
import com.youth4work.CGPSC_2023.network.model.Rank;

import java.util.List;

public class RanksAdapter extends RecyclerView.Adapter<RanksAdapter.RankViewHolder> {

    private Context context;
    private List<Rank> ranks;

    public RanksAdapter(Context context, List<Rank> ranks) {
        this.context = context;
        this.ranks = ranks;
    }

    public static String toTitleCase(String givenString) {
        System.out.print(givenString);
        String[] arr = givenString.split(" +");
        StringBuffer sb = new StringBuffer();
        if (arr.length > 1 ) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1).toLowerCase()).append(" ");
            }
        } else {
            sb.append(givenString);
        }

        return sb.toString().trim();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public RankViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rank, viewGroup, false);
        RankViewHolder pvh = new RankViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RankViewHolder rankViewHolder, int position) {
        Rank rank = ranks.get(position);
        rankViewHolder.txtUsername.setText(rank.getName().length() > 0 ? toTitleCase(rank.getName()) : rank.getName());
        rankViewHolder.txtRank.setText(rank.getRank() + "");
        Picasso.with(context).load(rank.getImgUrl()).into(rankViewHolder.imgUserAvatar);
    }

    @Override
    public int getItemCount() {
        return ranks.size();
    }

    public static class RankViewHolder extends RecyclerView.ViewHolder {

        CircularImageView imgUserAvatar;
        TextView txtUsername;
        TextView txtRank;

        RankViewHolder(@NonNull View itemView) {
            super(itemView);

            imgUserAvatar = (CircularImageView) itemView.findViewById(R.id.img_user_avatar);
            txtUsername = (TextView) itemView.findViewById(R.id.txt_username);
            txtRank = (TextView) itemView.findViewById(R.id.txt_rank);
        }
    }
}
