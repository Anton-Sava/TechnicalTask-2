package ua.antonsava.secondapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private FloatingActionButton mFab;

    private List<TabRecycleViewData> imageList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private TabRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.app_open, R.string.app_close);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.container_view, new TabFragment()).commit();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();


                if (menuItem.getItemId() == R.id.events) {
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_view, new TabFragment()).commit();
                }

                if (menuItem.getItemId() == R.id.on_map) {
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.container_view, new MapFragment()).commit();
                }
                return false;
            }
        });

//        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_tab);
//        mRecyclerView.setHasFixedSize(true);
//
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mRecyclerView.setLayoutManager(mLayoutManager);
//
//        reciveDataImage();
//
//        mAdapter = new TabRecyclerAdapter(MainActivity.this, imageList);
//        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

//    private void reciveDataImage() {
//        TabRecycleViewData data = new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія", R.drawable.ic_like
//                , "вул.Савченко 22", "22 квітня 2016", "7 днів");
//        imageList.add(data);
//
//
//        imageList.add(new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія", R.drawable.ic_like
//                , "вул.Савченко 22", "22 квітня 2016", "7 днів"));
//        imageList.add(new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія", R.drawable.ic_like
//                , "вул.Савченко 22", "22 квітня 2016", "7 днів"));
//        imageList.add(new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія", R.drawable.ic_like
//                , "вул.Савченко 22", "22 квітня 2016", "7 днів"));
//
//    }

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

    public void onScrollUp(boolean scrollUp) {
        if (scrollUp) {
            mFab.hide();
        } else {
            mFab.show();
        }
    }
}
