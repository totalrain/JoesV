package com.Joes.joesv01.app;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
    ArrayList<HashMap<String, Object>> todoListItem = new ArrayList<HashMap<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.teaListView);
        final ListView toDoList = (ListView) findViewById(R.id.toDoListView);



        for (int i = 0; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("Title", "Tea " + i);
            map.put("Text", "       6 元 ");
            listItem.add(map);
        }
        SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem, R.layout.item1, new String[]{"Title", "Text"}, new int[]{R.id.Title, R.id.Text});
        final SimpleAdapter toDoListItemAdapter = new SimpleAdapter(this, todoListItem, R.layout.item1, new String[]{"Title", "Text"}, new int[]{R.id.Title, R.id.Text});

        list.setAdapter(listItemAdapter);
        toDoList.setAdapter(toDoListItemAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setTitle("点击第" + position + "个项目");
                ViewGroup group = (ViewGroup) parent.getChildAt(position);
                TextView text1 = (TextView) group.getChildAt(0);
                TextView text2 = (TextView) group.getChildAt(1);

                String str1 = text1.getText().toString();
                String str2 = text2.getText().toString();

                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("Title", str1);
                map.put("Text", str2);
                System.out.println(str1 + str2);
                todoListItem.add(map);
                toDoList.setAdapter(toDoListItemAdapter);
            }
        });
    }

    //优化：将HashMap和Adapter分别写入一个类;将click方法移出
    /*public class itemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            setTitle("点击第" + position + "个项目");
            ViewGroup group = (ViewGroup) parent.getChildAt(position);
            TextView text1 = (TextView) group.getChildAt(0);
            TextView text2 = (TextView) group.getChildAt(1);

            String str1 = text1.getText().toString();
            String str2 = text2.getText().toString();

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("Title", text1);
            map.put("Text", text2);
            System.out.println(str1 + str2);

            todoListItem.add(map);
            toDoList.setAdapter(toDoListItemAdapter);
        }
    }*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/
}
