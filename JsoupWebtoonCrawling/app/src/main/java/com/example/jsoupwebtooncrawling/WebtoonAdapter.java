package com.example.jsoupwebtooncrawling;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WebtoonAdapter extends BaseAdapter {
    private ArrayList<Webtoon> webtoonItems;

    public WebtoonAdapter(ArrayList<Webtoon> webtoons) {
        webtoonItems = webtoons;
    }

    @Override
    public int getCount() {
        return webtoonItems.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.webtoon_layout, parent, false);
        }

        ImageView thumbnail = convertView.findViewById(R.id.thumbnail);
        TextView title = convertView.findViewById(R.id.webtoonTitle);
        TextView writer = convertView.findViewById(R.id.writer);
        TextView star = convertView.findViewById(R.id.star);

        Webtoon webtoon = webtoonItems.get(position);

        Glide.with(context).load(Uri.parse(webtoon.ThumbnailSrc())).into(thumbnail);
        title.setText(webtoon.Title());
        writer.setText(webtoon.Writer());
        star.setText(webtoon.Star());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return webtoonItems.get(position);
    }

    public void addItem() {

    }
}
