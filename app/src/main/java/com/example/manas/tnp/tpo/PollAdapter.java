package com.example.manas.tnp.tpo;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PollAdapter extends ArrayAdapter<PollForm> {
    public PollAdapter(Context context, int resource, List<PollForm> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_poll, parent, false);
        }

        TextView pollIDTextView = (TextView) convertView.findViewById(R.id.companyTextView);
        TextView companyTextView = (TextView) convertView.findViewById(R.id.linkTextView);

        PollForm pollForm = getItem(position);

            pollIDTextView.setText(pollForm.getPollID());

        companyTextView.setText(pollForm.getCompanyName());

        return convertView;
    }
}
