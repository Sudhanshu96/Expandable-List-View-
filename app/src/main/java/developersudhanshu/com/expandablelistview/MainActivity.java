package developersudhanshu.com.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import developersudhanshu.com.expandablelistview.Adapters.ExpandableListAdapter;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener {

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        expandableListView = (ExpandableListView) findViewById(R.id.exp_lv);

        List<String> groupData = new ArrayList<>();
        groupData.add("Mobiles");
        groupData.add("Laptops");
        groupData.add("TV");

        List<String> mobileData = new ArrayList<>();
        mobileData.add("Google Pixel");
        mobileData.add("Samsung");
        mobileData.add("OnePlus");
        mobileData.add("LG");
        mobileData.add("Motorola");

        List<String> laptopData = new ArrayList<>();
        laptopData.add("Apple");
        laptopData.add("HP");
        laptopData.add("Dell");
        laptopData.add("Lenovo");
        laptopData.add("Acer");

        List<String> tvData = new ArrayList<>();
        tvData.add("Sony");
        tvData.add("Samsung");
        tvData.add("LG");
        tvData.add("Panasonic");

        HashMap<String, List<String>> childData = new HashMap<>();
        childData.put(groupData.get(0), mobileData);
        childData.put(groupData.get(1), laptopData);
        childData.put(groupData.get(2), tvData);

        // Setting up the Adapter
        adapter = new ExpandableListAdapter(this, groupData, childData);

        expandableListView.setAdapter(adapter);
        // Implementing callback to get notified when a Child item is clicked
        expandableListView.setOnChildClickListener(this);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        TextView childItem = v.findViewById(R.id.tv_child_text);
        String item = childItem.getText().toString();
        Toast.makeText(this, item + " clicked!", Toast.LENGTH_SHORT).show();
        return true;
    }

}
