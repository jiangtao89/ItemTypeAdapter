package com.jt.funny.homepage.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.jt.funny.homepage.*;
import com.jt.funny.homepage.app.widget.ItemViewImageView;
import com.jt.funny.homepage.app.widget.ItemViewTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ItemViewManager mRepository;
    private ItemTypeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mListView = (ListView) findViewById(android.R.id.list);
        mRepository = ItemViewManager.getInstance();

        mRepository.addItemView("nullable", ItemViewManager.NULLABLE_ITEM_VIEW_PROPERTY);
        mRepository.addItemView("text", new ItemProperty(1, ItemViewTextView.ItemVO.class, ItemViewTextView.class));
        mRepository.addItemView("image", new ItemProperty(2, ItemViewImageView.ItemVO.class, ItemViewImageView.class));

        mAdapter = new ItemTypeAdapter(this, mRepository);
        mListView.setAdapter(mAdapter);

        mAdapter.setData(new ArrayList<ItemVO>() {
            {
                add(new NullableItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewTextView.ItemVO());
                add(new ItemViewImageView.ItemVO());
                add(new ItemViewImageView.ItemVO());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
