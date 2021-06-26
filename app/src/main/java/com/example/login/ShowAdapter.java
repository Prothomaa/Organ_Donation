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

public class ShowAdapter extends ArrayAdapter {
    private Activity mContext ;
   // List<Profile> profileList ;
    //List<Profile> profileList1 ;
    List<Request> requestList ;

    public ShowAdapter(Activity mContext  ,List<Request> requestList ){
        super(mContext,R.layout.show_item,requestList);
        //super(mContext,R.layout.show_item,requestList);
        this.mContext = mContext;
        //this.profileList = profileList;
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        //View listItemView = inflater.inflate(R.layout.list_item,null,true);
        //View listItemView1 = inflater.inflate(R.layout.list_item,null,true);
        View listItemView2 = inflater.inflate(R.layout.show_item,null,true);


     ;

        TextView email_text2 = listItemView2.findViewById(R.id.email_text);
        //TextView name_text2 = listItemView2.findViewById(R.id.name_text);
        TextView organ_text2 = listItemView2.findViewById(R.id.organ_text);
        TextView date_text2 = listItemView2.findViewById(R.id.date_text);


        Request request = requestList.get(position);
        email_text2.setText(request.getEmail());
        date_text2.setText(request.getDate());
        organ_text2.setText(request.getOrgan());


return listItemView2 ;

    }

}
