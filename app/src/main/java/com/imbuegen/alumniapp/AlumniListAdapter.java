package com.imbuegen.alumniapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AlumniListAdapter extends ArrayAdapter<AlumniModel> {
    private Activity context;
    private List<AlumniModel> alumniList;

    public AlumniListAdapter(Activity context,List<AlumniModel> alumniList)
    {
        super(context,R.layout.alumni_list_item,alumniList);
        this.context = context;
        this.alumniList = alumniList;
    }


    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {


        LayoutInflater inflater = context.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.alumni_list_item,null,true);

        TextView alumniNameTextView = (TextView) listItemView.findViewById(R.id.text_view_alumni_name);
        AlumniModel company = alumniList.get(position);

        alumniNameTextView.setText(company.getAlumniName());

        return listItemView;
    }
}
