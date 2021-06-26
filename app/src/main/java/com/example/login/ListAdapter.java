package com.example.login;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext ;
    List<Profile> profileList ;

    public ListAdapter(Activity mContext , List<Profile> profileList){
        super(mContext,R.layout.list_item,profileList);
        this.mContext = mContext;
        this.profileList = profileList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null,true);

        TextView email_text = listItemView.findViewById(R.id.email_text);
        TextView name_text = listItemView.findViewById(R.id.name_text);
        TextView organ_text = listItemView.findViewById(R.id.organ_text);

        Profile profile = profileList.get(position);
        email_text.setText(profile.getEmail());
        name_text.setText(profile.getName());
        organ_text.setText(profile.getOrgan());

        return listItemView ;
    }
}
