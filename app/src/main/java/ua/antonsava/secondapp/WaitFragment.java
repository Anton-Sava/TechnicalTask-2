package ua.antonsava.secondapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Apple on 20.04.2016.
 */
public class WaitFragment extends Fragment {

    List<TabRecycleViewData> mTabListView;
    TabListAdapter tabListAdapter;

    public WaitFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater
            , ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.wait_layout, container, false);
        ListView mListView = (ListView) rootView.findViewById(R.id.list_view_tab);


        reciveDataImage();
        tabListAdapter = new TabListAdapter(getActivity(), mTabListView);

        return inflater.inflate(R.layout.wait_layout,null);
    }

    private void reciveDataImage() {
        TabRecycleViewData data = new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія"
                , "вул.Савченко 22, м.Дніпропетровськ", "22 квітня 2016", "7 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія"
                , "вул.Кедріна 47, м.Дніпропетровськ", "18 квітня 2016", "5 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_social, "Соціальна подія"
                , "вул.Карла Маркса 60, м.Дніпропетровськ", "15 квітня 2016", "3 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія"
                , "вул.Глінкі 17, м.Дніпропетровськ", "17 квітня 2016", "12 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія"
                , "вул.Шевченка 94, м.Дніпропетровськ ", "13 квітня 2016", "7 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_party, "Розважальна подія"
                , "вул.Кірова 5, м.Дніпропетровськ ", "3 квітня 2016", "5 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_social, "Соціальна подія"
                , "вул.Гагаріна 175, м.Дніпропетровськ ", "9 квітня 2016", "9 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія"
                , "вул.Тітова 1, м.Дніпропетровськ ", "9 квітня 2016", "5 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_party, "Розважальна подія"
                , "вул.Робоча 122, м.Дніпропетровськ ", "3 квітня 2016", "7 днів", R.drawable.ic_like);
        mTabListView.add(data);
        data = new TabRecycleViewData(R.drawable.ic_sport, "Спортивна подія"
                , "вул.Перемоги 145, м.Дніпропетровськ ", "20 квітня 2016", "9 днів", R.drawable.ic_like);
        mTabListView.add(data);

    }
}
