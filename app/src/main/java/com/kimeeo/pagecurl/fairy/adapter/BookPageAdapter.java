package com.kimeeo.pagecurl.fairy.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import com.kimeeo.pagecurl.fairy.entity.Page;

import java.util.List;

/**
 * Created by Mykola.Koshurenko on 11/21/13.
 */
public class BookPageAdapter extends ArrayAdapter<Page>{

    public BookPageAdapter(Context context, List<Page> objects) {
        super(context,-1, objects);
    }
}
