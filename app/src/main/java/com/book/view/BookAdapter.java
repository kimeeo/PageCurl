package com.book.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.kimeeo.pagecurl.R;


public class BookAdapter implements IAdapter{
	private BookLayout mBookLayout;
	private List<String> strList = new ArrayList<String>();
    private List<Integer> colorList = new ArrayList<Integer>();

	private Context mContext;
	public BookAdapter(Context context) {
		super();
		this.mContext = context;
	}
	public BookAdapter(Context context,BookLayout bk) {
		this(context);
		this.mBookLayout= bk;
	}

	public void addItem(List<String> list){
		strList.addAll(list);
	}
    public void addColors(List<Integer> list){
        colorList.addAll(list);
    }
	public int getCount() {
		return strList.size();
	}

	public String getItem(int position) {
		return strList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position) {
		LayoutInflater li=LayoutInflater.from(mContext);
		View view =li.inflate(R.layout.page,null);
        view.setBackgroundColor(colorList.get(position));


		TextView textView = (TextView) view.findViewById(R.id.textView);
		textView.setText(strList.get(position));

		View radioButton=view.findViewById(R.id.radioButton);
		View switch1=view.findViewById(R.id.switch1);
		View button=view.findViewById(R.id.button);
		View.OnClickListener click = new View.OnClickListener()
		{

			@Override
			public void onClick(View v) {
                mBookLayout.update();
			}
		};
		radioButton.setOnClickListener(click);
		switch1.setOnClickListener(click);
		button.setOnClickListener(click);


		return view;
	}

}
