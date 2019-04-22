package com.example.acm_app_alejandro;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerHackathons extends
        RecyclerView.Adapter<RecyclerHackathons.RecyclerViewHolder>{

    private List<Event> mHackathons;
    private Context mContext;

    public RecyclerHackathons(List<Event> hackathons, Context context){
        this.mHackathons = hackathons;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item, viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i){
        recyclerViewHolder.bind(i);
    }

    @Override
    public int getItemCount(){
        return mHackathons.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // These are the variables for each view
        ImageView mEventImage;
        TextView mEventTitle;
        TextView mEventStart;
        TextView mEventLocation;

        // Here in the RecyclerViewHolder, we instantiate each view by finding their ID
        // Since findViewById returns a view, we must type cast it to match each type of variables
        // defined above.
        public RecyclerViewHolder(View itemView){
            super(itemView);
            mEventImage = (ImageView) itemView.findViewById(R.id.image_url);
            mEventTitle = (TextView) itemView.findViewById(R.id.event_title);
            mEventStart = (TextView) itemView.findViewById(R.id.start_date);
            mEventLocation = (TextView) itemView.findViewById(R.id.location);
        }

        // Here we bind the information with the view itself
        public void bind(final int position){
            Picasso.with(mContext).load(mHackathons.get(position).getImageUrl()).into(mEventImage);
            mEventTitle.setText(mHackathons.get(position).getName());
            mEventStart.setText(mHackathons.get(position).getStartDate());
            mEventLocation.setText(mHackathons.get(position).getLocation());
            // Also set each item view to have onClickListener
            itemView.setOnClickListener(this);
        }

        // Now we give functionality to the Onclick
        // Open up the URL on a browser
        @Override
        public void onClick(View view){
            String urlString = mHackathons.get(getAdapterPosition()).getUrl();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
            mContext.startActivity(browserIntent);
        }

    }

}
