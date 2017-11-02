package com.example.jonathanlarsen.pensionconsultmainpage.rss_feed.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jonathanlarsen.pensionconsultmainpage.rss_feed.Interface.ItemClickListener;
import com.example.jonathanlarsen.pensionconsultmainpage.rss_feed.Model.RSSObject;
import com.example.jonathanlarsen.pensionconsultmainpage.R;

/**
 * Created by Mads on 29-10-2017.
 */

class FeedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{


    public TextView textTitle,textPubDate,textContent;
    private ItemClickListener itemClickListener;

    public FeedViewHolder(View itemView) {
        super(itemView);

        textTitle = (TextView) itemView.findViewById(R.id.textTitle);
        textPubDate = (TextView) itemView.findViewById(R.id.textPubDate);
        textContent = (TextView) itemView.findViewById(R.id.textContent);

        //textContent.setLinksClickable(true);

        // Set Event

/*      itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

        itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                System.out.println("Klikkede igen");
            }
        };
*/
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        System.out.println("Klikkede på noget");
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view, getAdapterPosition(), false);

    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }
}

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;


    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.rss_row,parent, false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {

        holder.textTitle.setText(rssObject.getItems().get(position).getTitle());
        System.out.println("item titel nr "+position + "  "+ rssObject.getItems().get(position).getTitle());
        holder.textPubDate.setText(rssObject.getItems().get(position).getPubDate());
        holder.textContent.setText(Html.fromHtml(rssObject.getItems().get(position).getContent()));

//        holder.textContent.setMovementMethod(LinkMovementMethod.getInstance());

        holder.textContent.setLinksClickable(true);

    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
