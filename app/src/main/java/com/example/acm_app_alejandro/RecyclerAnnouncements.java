package com.example.acm_app_alejandro;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAnnouncements extends
        RecyclerView.Adapter<RecyclerAnnouncements.RecyclerViewHolder> {
    // Variable for list Announcement from constructor
    private List<Announcement> announcements;
    private Context mContext;

    public RecyclerAnnouncements(List<Announcement> announcements, Context context){
        this.announcements = announcements;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_announcement,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i){
        recyclerViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        //These are the variables for each view.
        ImageView mAnnouncementImage;
        TextView mAnnouncementTitle;
        TextView mAnnouncementDate;
        TextView mAnnouncementBody;
        TextView mAnnouncementAuthor;

        //Here in the RecyclerViewHolder, we instantiate each View by finding their id.
        //Since findViewById returns a view, we must type-cast it to match each type of the variables above.
        public RecyclerViewHolder(View itemView){
            super(itemView);
            mAnnouncementImage = (ImageView) itemView.findViewById(R.id.announcement_image_url);
            mAnnouncementTitle = (TextView) itemView.findViewById(R.id.announcement_title);
            mAnnouncementDate = (TextView) itemView.findViewById(R.id.announcement_date);
            mAnnouncementBody = (TextView) itemView.findViewById(R.id.announcement_body);
            mAnnouncementAuthor = (TextView) itemView.findViewById(R.id.announcement_author);
        }

        //Here, we bind the information with the view itself.
        void bind(final int position){
            Picasso.with(mContext).load(announcements.get(position).getImageUrl()).into(mAnnouncementImage);
            mAnnouncementTitle.setText(announcements.get(position).getTitle());
            mAnnouncementDate.setText(announcements.get(position).getDate());
            mAnnouncementBody.setText(announcements.get(position).getBody());
            mAnnouncementAuthor.setText(announcements.get(position).getAuthor());
        }
    }
}
