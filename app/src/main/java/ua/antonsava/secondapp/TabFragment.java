package ua.antonsava.secondapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Apple on 20.04.2016.
 */
public class TabFragment extends Fragment {
    public static TabLayout sTabLayout;
    public static ViewPager sViewPager;
    public static int sIntItems = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View maket = inflater.inflate(R.layout.tab_layout, null);
        sTabLayout = (TabLayout) maket.findViewById(R.id.tabs);
        sViewPager = (ViewPager) maket.findViewById(R.id.view_pager);

        /**
         *Set an Apater for the View Pager
         */
        sViewPager.setAdapter(new Adapter(getChildFragmentManager()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        sTabLayout.post(new Runnable() {
            @Override
            public void run() {
                sTabLayout.setupWithViewPager(sViewPager);
            }
        });
        return maket;
    }

    class Adapter extends FragmentPagerAdapter {
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MakesFragment();
                case 1:
                    return new DoneFragment();
                case 2:
                    return new WaitFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return sIntItems;
        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Проведення";
                case 1:
                    return "Нещодавно відбулися";
                case 2:
                    return "Найближчі події";
            }
            return null;
        }
    }
}

