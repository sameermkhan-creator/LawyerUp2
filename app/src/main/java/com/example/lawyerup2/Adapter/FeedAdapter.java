package com.example.lawyerup2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lawyerup2.Interface.ItemClickListener;
import com.example.lawyerup2.R;
import com.example.lawyerup2.model.RSSObject;

import org.w3c.dom.Text;

class FeedViewHolder extends RecyclerView.ViewHolder{
public TextView txtTitle, txtPubDate, txtContent;
private ItemClickListener itemClickListener;

    public FeedViewHolder(@NonNull View itemView) {
        super(itemView);
        txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
        txtPubDate = (TextView)itemView.findViewById(R.id.txtPubDate);
        txtContent = (TextView)itemView.findViewById(R.id.txtContent);

/*
        //set event
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
*/
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
/*
    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
 */
}
public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder>{
private RSSObject rssObject;
private Context mContext;
private LayoutInflater inflater;


public FeedAdapter(RSSObject rssObject, Context mContext){
    this.rssObject = rssObject;
    this.mContext =  mContext;
    inflater =LayoutInflater.from(mContext);
}

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.row,parent,false);
        return new FeedViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
       holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
       holder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());
       holder.txtContent.setText(rssObject.getItems().get(position).getContent());
/*
       holder.setItemClickListener((view, position1, isLongClick) -> {
           if(!isLongClick){
               Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.getItems().get(position1).getLink()));
               mContext.startActivity(browserIntent);
           }
       });
*/
    }

    @Override
    public int getItemCount() {
    return rssObject.items.size();

    }
}
