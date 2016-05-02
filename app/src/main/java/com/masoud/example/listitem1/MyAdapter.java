package com.masoud.example.listitem1;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by MASOUD on 5/1/2016.
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private List<String> header_title;
    private HashMap<String, List<String>> child_title;
    private Context ctx;

    MyAdapter(Context ctx, List<String> header_title, HashMap<String, List<String>> child_title) {
        this.ctx = ctx;
        this.child_title = child_title;
        this.header_title = header_title;
    }

    @Override
    public int getGroupCount() {
        return header_title.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_title.get(header_title.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header_title.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_title.get(header_title.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title= (String) this.getGroup(groupPosition);
        if(convertView==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.parentlayout,null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textViewheadingitemParent);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String) this.getChild(groupPosition, childPosition);
        if(convertView==null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.child_layout,null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.textViewheadingitemChild);

         textView.setText(title);
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
