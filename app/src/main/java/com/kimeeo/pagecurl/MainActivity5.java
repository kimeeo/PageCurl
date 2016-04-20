package com.kimeeo.pagecurl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.book.view.BookAdapter;
import com.book.view.BookLayout;

public class MainActivity5 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_5);

        BookLayout bk = (BookLayout) findViewById(R.id.bookLayout);
        List<String> str = new ArrayList<String>();
        str.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        str.add("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        str.add("ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        str.add("ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        BookAdapter ba = new BookAdapter(this,bk);
        ba.addItem(str);

        Random rnd = new Random();
        List<Integer> colr = new ArrayList<Integer>();
        colr.add(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        colr.add(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        colr.add(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        colr.add(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        ba.addColors(colr);
        bk.setPageAdapter(ba);
    }
}